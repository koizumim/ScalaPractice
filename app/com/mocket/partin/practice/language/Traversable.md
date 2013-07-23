# Traversable traitについてのノート

Traversableは、Scalaのコレクションクラスの最上位に位置するトレイトだ。
Traversableの1階層下にはIterable, Set, Mapがある。

Traversableはトレイトだが、ファクトリーメソッドによってインスタンス化することができる。

`scala> Traversable(1,2,3)
 res8: Traversable[Int] = List(1, 2, 3)`

 これを見ると、TraversableのファクトリーメソッドはListのデフォルト実装によってインスタンス化されていそうな気がする。

 ## Traversableの実装

 Traversableの唯一の抽象メソッドはforeachである。
 故に、foreachさえ実装すればTraversableを実装したことになる。

 のだが、実際にTraversableを実装したコレクションを使いたいなら、他のメソッドもoverrideしないといけない気がする。

 例えばCollectionPractice.scalaにあるMyTripleクラスのように、本当にforeachだけを実装したとする。
 このとき例えば++を呼び出すと、次のようになる。


`scala> val t1 = new MyTriple[Int](1,2,3)
t1: com.mocket.partin.practice.language.MyTriple[Int] = MyTriple(1, 2, 3)

scala> t1 ++ t1
res1: Traversable[Int] = List(1, 2, 3, 1, 2, 3)`

つまり、2つのMyTripleを足し合わせた結果がMyTripleではなくListで返されてしまう。
これは実際にMyTripleクラスを使うユーザー（が、存在したとして）にとって、自然な振る舞いではないだろう。

同じことはfilterなどのメソッドについてもいえる。

`scala> t1.filter(_ > 1)
 res7: Traversable[Int] = List(2, 3)`

 そこで、次のような問いが出てくる。

 「Traversableを実装するクラスCをつくるとき、Traversableを返却するメソッドがすべてCを返却するようにするために、最低限overrideしておかなければいけないメソッドは何か？」

 これは次の課題とする。
Clojure-8QueensSolver
=====================


８クイーン問題の回答プログラムです。  

８x８マスの盤面において縦・横・斜めの線上に駒（クイーン）が１つしか無いように８個の駒を配置するという問題です。並べ方は複数通りありますが、そのうちの１通りを求めます。具体例を見た方が分かりやすいですね。マス目を減らして４クイーン問題の解答を以下に示します。

```
+-+-+-+-+
| |Q| | |
+-+-+-+-+
| | | |Q|
+-+-+-+-+
|Q| | | |
+-+-+-+-+
| | |Q| |
+-+-+-+-+
```

なお、[Newral技術者ブログ](http://newral.info/publics/index/79/&anchor_link=page79_341#page79_341)というサイトでプログラミングの過程を記事にしております。是非ご覧下さい。

###記事へのリンク  
[Clojureで８クイーン問題にチャレンジ(Part1)](http://newral.info/publics/index/79/page341=7/r_id=101/c_id=341/detail=1/&anchor_link=page79_341_101#page79_341_101)  
[Clojureで８クイーン問題にチャレンジ(Part2)](http://newral.info/publics/index/79/page341=6/r_id=102/c_id=341/detail=1/&anchor_link=page79_341_102#page79_341_102)  
[Clojureで８クイーン問題にチャレンジ(Part3)](http://newral.info/publics/index/79/page341=6/r_id=125/c_id=341/detail=1/&anchor_link=page79_341_125#page79_341_125)  
[Clojureで８クイーン問題にチャレンジ(Part4)](http://newral.info/publics/index/79/page341=6/r_id=175/c_id=341/detail=1/&anchor_link=page79_341_175#page79_341_175)  
[Clojureで８クイーン問題にチャレンジ(Part5)](http://newral.info/publics/index/79/page341=6/r_id=177/c_id=341/detail=1/&anchor_link=page79_341_177#page79_341_177)  

###ソースコードガイド

eightqueens.clj (上記記事でプログラミングしたソースコード)  

###実行方法

eightqueens.cljはleiningenというclojureのビルドツールをインストールして`lein repl`でREPL環境を立ち上げて実行します。

```
bash-3.2$ lein repl
user=> (load-file "eightqueens.clj")
#'user/answer
user=> (answer)
((1 5) (2 1) (3 4) (4 6) (5 8) (6 2) (7 7) (8 3))
user=> (quit)
```

結果は8個のQueenの位置をリストにして返します。アスキーアートで並べてみると以下のようになります。

```
+-+-+-+-+-+-+-+-+
| | | | |Q| | | |
+-+-+-+-+-+-+-+-+
|Q| | | | | | | |
+-+-+-+-+-+-+-+-+
| | | |Q| | | | |
+-+-+-+-+-+-+-+-+
| | | | | |Q| | |
+-+-+-+-+-+-+-+-+
| | | | | | | |Q|
+-+-+-+-+-+-+-+-+
| |Q| | | | | | |
+-+-+-+-+-+-+-+-+
| | | | | | |Q| |
+-+-+-+-+-+-+-+-+
| | |Q| | | | | |
+-+-+-+-+-+-+-+-+
```


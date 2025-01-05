# stackのキャッシュ(.stack-work)クリア
> stack clean


# 特定のパッケージを指定してビルド
> stack build パッケージ名
ex
> stack build beginner111

# 特定の実行ファイルのみビルド
> stack build パッケージ名:exe:実行対象
ex
> stack build beginner111:exe:beginner111-a

# 特定のテストのみ実行
> stack build パッケージ名:test:テスト対象
ex
> stack build beginner111:test:beginner111-test
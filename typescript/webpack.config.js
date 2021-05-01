const { CleanWebpackPlugin } = require('clean-webpack-plugin');

module.exports = {
  mode: 'development',
  entry: {
    dp_a: './atcoder/dp/a.ts',
    dp_b: './atcoder/dp/b.ts'
  },
  output: {
    path: __dirname + '/dist',
    publicPath: '/',
    filename: '[name].bundle.js',
  },
  target: 'node',
  module: {
    rules: [
      {
        enforce: 'pre',
        test: /\.tsx?$/,
        use: [
          {
            loader: 'tslint-loader',
            options: {
              typeCheck: true,
              fix: true,
            },
          },
        ],
      },
      {
        test: /\.ts$/,
        use: ['ts-loader'],
        exclude: /node_modules/
      }
    ]
  },
  resolve: {
    extensions: [ '.tsx', '.ts', '.js' ]
  },
  plugins: [
    new CleanWebpackPlugin({ verbose: true })
  ],
  devServer: {
    contentBase: './dist',
    hot: true
  }
};

var path = require('path');

module.exports = {
    entry: './src/app.js',
    devtool: 'eval', // https://webpack.js.org/configuration/devtool/
    cache: true,
    mode: 'development',
    output: {
        path: __dirname,
        filename: './resources/static/built/bundle.js'
    },
    module: {
        rules: [
            {
                test: path.join(__dirname, '.'),
                exclude: /(node_modules)/,
                use: [{
                    loader: 'babel-loader',
                    options: {
                        presets: ["@babel/preset-env", "@babel/preset-react"]
                    }
                }]
            }
        ]
    }
};
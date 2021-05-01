/*
 * ATTENTION: The "eval" devtool has been used (maybe by default in mode: "development").
 * This devtool is neither made for production nor for readable output files.
 * It uses "eval()" calls to create a separate source file in the browser devtools.
 * If you are trying to read the output file, select a different devtool (https://webpack.js.org/configuration/devtool/)
 * or disable the default devtool with "devtool: false".
 * If you are looking for production-ready output files, see mode: "production" (https://webpack.js.org/configuration/mode/).
 */
/******/ (() => { // webpackBootstrap
/******/ 	"use strict";
/******/ 	var __webpack_modules__ = ({

/***/ "./atcoder/dp/a.ts":
/*!*************************!*\
  !*** ./atcoder/dp/a.ts ***!
  \*************************/
/***/ ((__unused_webpack_module, exports) => {

eval("\r\nObject.defineProperty(exports, \"__esModule\", ({ value: true }));\r\nexports.main = void 0;\r\n(function (f, n) {\r\n    var input = [];\r\n    var temp = \"\";\r\n    process.stdin.resume();\r\n    process.stdin.setEncoding('utf8');\r\n    process.stdin.on('data', function (data) {\r\n        temp = temp.concat(data);\r\n        while (true) {\r\n            var index = temp.indexOf(\"\\n\");\r\n            if (index > 0) {\r\n                input.push(temp.substr(0, index));\r\n                temp = temp.substr(index + 1);\r\n            }\r\n            else {\r\n                break;\r\n            }\r\n        }\r\n        if (input.length == n) {\r\n            f(input);\r\n            process.exit(0);\r\n        }\r\n    });\r\n})(main, 2);\r\nfunction main(input) {\r\n    var n = Number(input[0]);\r\n    var h = input[1].split(/ +/).map(function (x) { return Number(x); });\r\n    function solve(n, h) {\r\n        var dp = h.map(function () { return -1; });\r\n        ;\r\n        for (var i = 0; i < n - 1; i++) {\r\n            if (i + 2 <= n - 1)\r\n                dp[i + 2] = Math.max(0, dp[i]) + Math.abs(h[i + 2] - h[i]);\r\n            var x = Math.max(0, dp[i]) + Math.abs(h[i + 1] - h[i]);\r\n            if (dp[i + 1] > x || dp[i + 1] == -1) {\r\n                dp[i + 1] = x;\r\n            }\r\n        }\r\n        return dp[n - 1];\r\n    }\r\n    console.log(solve(n, h));\r\n}\r\nexports.main = main;\r\n\n\n//# sourceURL=webpack://kyopro_typescript/./atcoder/dp/a.ts?");

/***/ })

/******/ 	});
/************************************************************************/
/******/ 	
/******/ 	// startup
/******/ 	// Load entry module and return exports
/******/ 	// This entry module can't be inlined because the eval devtool is used.
/******/ 	var __webpack_exports__ = {};
/******/ 	__webpack_modules__["./atcoder/dp/a.ts"](0, __webpack_exports__);
/******/ 	
/******/ })()
;
(function(){function r(e,n,t){function o(i,f){if(!n[i]){if(!e[i]){var c="function"==typeof require&&require;if(!f&&c)return c(i,!0);if(u)return u(i,!0);var a=new Error("Cannot find module '"+i+"'");throw a.code="MODULE_NOT_FOUND",a}var p=n[i]={exports:{}};e[i][0].call(p.exports,function(r){var n=e[i][1][r];return o(n||r)},p,p.exports,r,e,n,t)}return n[i].exports}for(var u="function"==typeof require&&require,i=0;i<t.length;i++)o(t[i]);return o}return r})()({1:[function(require,module,exports){
// 👇️ if using ES6 Imports uncomment line below
// import {readFileSync, promises as fsPromises} from 'fs';
const {readFileSync, promises: fsPromises} = require('fs');

// ✅ read file SYNCHRONOUSLY
function syncReadFile(filename) {
    const contents = readFileSync(filename, 'utf-8');

    const arr = contents.split(/\r?\n/);

    //console.log(arr); // 👉️ ['One', 'Two', 'Three', 'Four']

    return arr;
}

function toHTML() {
    let arr = syncReadFile('/home/jc515081/Coding/Java/PythonShapeOfFractions/res/arrays.txt');
    return arr;
}
//document.getElementById("result1").innerHTML = arr[0];
//document.getElementById("result2").innerHTML = arr[1];
},{"fs":2}],2:[function(require,module,exports){

},{}]},{},[1]);

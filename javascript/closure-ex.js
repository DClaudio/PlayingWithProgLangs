
/* 
(first class citizen - supports all the operations generally available to entities)
- first class function:
	- passing functions as arguments  to other functions;
	- returning functions as the values from other functions;
	- assign functions to variables or storing them in data structures;
- higher-order functions (math/conputer science term):
	- takes one or more functions as input;
	- outputs a function;

- scope: global vs local;
- nested functions;
- annonimous functions;

Functional Programming Languages: LISP - Scheme - Javascript
(Turing machine and lambda calculus as Entscheidungsproblem solution -
 von Newman architecture: input device -> (CPU, RAM) -> output device )

*/

// Anonimous function example
var displayClosure = function() {
    var count = 0;
    return function () {
        return ++count;
    };
}
var inc = displayClosure();
inc(); // returns 1
inc(); // returns 2
inc(); // returns 3


// Example 1
function sayHello2(name) {
    var text = 'Hello ' + name; // Local variable
    var sayAlert = function() { alert(text); }
    return sayAlert;
}
say2 = sayHello2('Bob');
say2(); // alerts "Hello Bob"

// A closure is the local variables for a function kept alive after the function has returned
// A closure is a stack-frame which is not deallocated when the function returns. 
// about stacks: https://en.wikipedia.org/wiki/Call_stack#Structure

// Example 2
var displayClosure = function() {
    var count = 0;
    return function () {
        return ++count;
    };
}
var inc = displayClosure();
inc(); // returns 1
inc(); // returns 2
inc(); // returns 3

//Example 3
function multiplyWith(x){
	return function(y){
		return x * y;
	}
}

var multiplyWithTwo = multiplyWith(2);
// multiplyWithTwo is now a closure
var shouldBeFour = multiplyWithTwo(2);

// Conclusion: Simply accessing variables outside of your immediate lexical scope creates a closure

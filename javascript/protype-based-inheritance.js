/*
	OOP class-based vs prototype-based
	- class-bases: defining classes of objects 
	- prototype-based: cloning existing objects that serve as prototypes;
*/

//object creation example
var foo = {name: "foo", one: 1, two: 2};
var bar = {two: "two", three: 3};
bar.__proto__ = foo; // foo is now the prototype of bar
//bar has now all the behaviour of foo object;
bar.one // Resolves to 1.
//another way to inherit:
var buzz = Object.create(bar);


// 2nd Example:
var Animal = function(){
	this.name = 'unknown';
	this.getName = function(){
		return this.name;
	}
	return this;
};
var Dog = function() {
	var private = 42;
	this.name = "Bello";
	this.bark = function(){
		return "ham ham";
	}
	return this;
}
//dog now has animal as a superclass
Dog.prototype = new Animal();

var dog = new Dog();

// Proving our case
console.log(
    "Is dog an instance of Dog? ", dog instanceof Dog, "\n",
    "Is dog an instance of Animal? ", dog instanceof Animal, "\n",
    dog.bark() +"\n", // Should be: "MEOW"
    dog.getName() +"\n", // Should be: "Bello"
    dog.private +"\n" // Should be: 'undefined'
);


// 3rd Example
function Animal(name) {};
Animal.prototype.eat = function() {};
Animal.prototype.say = function(message) {};
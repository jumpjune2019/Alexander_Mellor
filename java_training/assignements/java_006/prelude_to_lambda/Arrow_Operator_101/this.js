console.log("");
console.log("*** This Tests ***");
console.log("");
// General
// define a function
const myFunction = () => {
  console.log(this);
};
// call it
myFunction();

// Lambda
const myObject0 = {
  myMethod: () => {
    console.log(this);
  }
};
myObject0.myMethod() // this === window or global object
const myMethod0 = myObject0.myMethod;
myMethod0() // this === window or global object
const myObject = {
  myArrowFunction: null,
  myMethod: function () {
    this.myArrowFunction = () => { console.log(this) };
  }
};
myObject.myMethod() // this === myObject
myObject.myArrowFunction() // this === myObject
const myArrowFunction = myObject.myArrowFunction;
myArrowFunction() // this === myObject
// Binding Tests
const myMethod = () => {
  console.log(this);
};
const myObject2 = {};
myMethod.call(myObject2) // this === window or global object
myMethod.apply(myObject2) // this === window or global object
const myMethodBound = myMethod.bind(myObject2);
myMethodBound(); // this === window or global object
new myMethod(); // Uncaught TypeError: myMethod is not a constructor

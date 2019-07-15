console.log("");
console.log("*** General Lambda Tests ***");
console.log("");
// Lambda Test Samples
const multiplyES6 = (x, y) => x * y;  // Multiple Paramaters
const phraseSplitterEs6 = phrase => phrase.split(" ");  // One Paramater
var docLogEs6 = () => { console.log(document); }; // No Paramaters
var setNameIdsEs6 = (id, name) => ({ id: id, name: name }); // Object Literal

console.log("5 * 5");
console.log(multiplyES6(5, 5));

console.log("Split Test Phrase");
console.log(phraseSplitterEs6("Split Test Phrase"));

console.log("Zero Arguments");
console.log(docLogEs6());

console.log("Object Literal");
console.log(setNameIdsEs6(6, "Ale"));

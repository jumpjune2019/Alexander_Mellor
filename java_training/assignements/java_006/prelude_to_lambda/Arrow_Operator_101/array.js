console.log("");
console.log("*** Array Tests ***");
console.log("");
// Array Manipulation
const smartPhones = [
  { name:'iphone', price:649 },
  { name:'Galaxy S6', price:576 },
  { name:'Galaxy Note 5', price:489 }
];
const prices = smartPhones.map(smartPhone => smartPhone.price);
console.log("Array Manipulation");
console.log(prices); // [649, 576, 489]

const array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];
const divisibleByThrreeES6 = array.filter(v => v % 3 === 0);
console.log("Reduce Array");
console.log(divisibleByThrreeES6); // [3, 6, 9, 12, 15]

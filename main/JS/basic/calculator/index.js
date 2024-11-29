const readline = require("readline-sync");

//Historico de operacoes
let history = [];

//funcoes de operacoes
function add(a, b) {
  return a + b;
}

function sub(a, b) {
  return a - b;
}

function multiply(a, b) {
  return a * b;
}

function divide(a, b) {
  if (b != 0) {
    return a / b;
  } else {
    console.log("Error: cannot divide by zero");
  }
}

//loop principal
function calculator() {
  console.log("Simple calculator");
  console.log("Choose an operation: ");
  console.log("1 - Addition");
  console.log("2 - Subtraction");
  console.log("3 - Multiplication");
  console.log("4 - Division");
  console.log("5 - History");
  console.log("0 - Exit");

  const choice = readline.question("Enter your choice: ");

  if (choice === "0") {
    console.log("See ya soon");
    return;
  }

  if (choice >= "6") {
    console.log("Invalid choice");
    return;
  }

  if (choice === "5") {
    console.log("History of operations: ");
    history.forEach((operation, index) => {
      console.log(`${index + 1}. ${operation}`);
    });
    calculator();
    return;
  }

  const num1 = parseFloat(readline.question("Enter first number: "));
  const num2 = parseFloat(readline.question("Enter second number: "));

  let result;
  switch (choice) {
    case "1":
      result = add(num1, num2);
      history.push(`${num1} + ${num2} = ${result}`);
      break;
    case "2":
      result = sub(num1, num2);
      history.push(`${num1} - ${num2} = ${result}`);
      break;
    case "3":
      result = multiply(num1, num2);
      history.push(`${num1} * ${num2} = ${result}`);
      break;
    case "4":
      result = divide(num1, num2);
      history.push(`${num1} / ${num2} = ${result}`);
      break;
  }

  console.log(`Result: ${result}`);
  calculator();
}

calculator();

function generateAlphabet(num) {
  if (num < 1 || num > 26) {
    console.log("Number must be between 1 and 26");
    return;
  }

  const letters = [];
  for (let i = 0; i < num; i++) {
    letters.push(String.fromCharCode(65 + i)); // 65 é o código ASCII para 'A'
  }

  console.log(letters.join(", "));
}

generateAlphabet(12);

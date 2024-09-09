function alphabet(num: number): void {
  if (num < 1 || num > 26) {
    console.log("Number must be between 1 and 26");
    return;
  }

  const letters: string[] = [];
  for (let i = 0; i < num; i++) {
    letters.push(String.fromCharCode(65 + i));
  }

  console.log(letters.join(", "));
}

alphabet(12);

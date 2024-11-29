// Add event listener to navigation links
document.querySelectorAll("nav a").forEach((link) => {
  link.addEventListener("click", (event) => {
    event.preventDefault();
    const targetId = link.getAttribute("href").substring(1);
    document.getElementById(targetId).scrollIntoView({ behavior: "smooth" });
  });
});

document.addEventListener("DOMContentLoaded", () => {
  // Rolagem suave para os links de navegação
  const links = document.querySelectorAll("nav a");
  links.forEach((link) => {
    link.addEventListener("click", (e) => {
      e.preventDefault();
      const targetId = link.getAttribute("href").substring(1);
      const targetElement = document.getElementById(targetId);
      window.scrollTo({
        top: targetElement.offsetTop,
        behavior: "smooth",
      });
    });
  });

  // Validação básica do formulário de contato
  const form = document.querySelector("#contato form");
  form.addEventListener("submit", (e) => {
    const name = form.querySelector('input[type="text"]').value.trim();
    const email = form.querySelector('input[type="email"]').value.trim();
    const message = form.querySelector("textarea").value.trim();

    if (name === "" || email === "" || message === "") {
      e.preventDefault(); // Impede o envio do formulário
      alert("Por favor, preencha todos os campos.");
      return;
    }

    if (!validateEmail(email)) {
      e.preventDefault(); // Impede o envio do formulário
      alert("Por favor, insira um e-mail válido.");
      return;
    }

    // Aqui você pode adicionar código para enviar o formulário via AJAX, se desejar
  });

  function validateEmail(email) {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(email);
  }
});

function openTab(tabName) {
  var tabContents = document.getElementsByClassName("tab-content");
  for (var i = 0; i < tabContents.length; i++) {
    tabContents[i].style.display = "none";
  }
  document.getElementById(tabName).style.display = "block";
}

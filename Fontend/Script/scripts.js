var dropdown = document.getElementsByClassName("dropdown-btn");
var i;

for (i = 0; i < dropdown.length; i++) {
    dropdown[i].addEventListener("click", function () {
        this.classList.toggle("active");
        var dropdownContent = this.nextElementSibling;
        if (dropdownContent.style.display === "block") {
            dropdownContent.style.display = "none";
        } else {
            dropdownContent.style.display = "block";
        }
    });
}

function openNav() {
    document.getElementById("myNav").style.width = "100%";
}

function closeNav() {
    document.getElementById("myNav").style.width = "0%";
}

// function openNav() {
//     console.log("aaaa");
//     var leftMenu = document.getElementById("menu-left");
//     console.log(leftMenu.style.display);
//     if (leftMenu.style.display === "") {
//         console.log("none");
//         leftMenu.classList.add("open-menu-left");
//         console.log(leftMenu.style.display);
//     } else {
//         leftMenu.classList.remove("open-menu-left");
//     }
// }

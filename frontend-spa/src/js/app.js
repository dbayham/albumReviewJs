import{
    createHeader
} from "./header.js"

import{
    createFooter
}from "./footer.js"

import{
    displayHomeView
}from "./displayHomeView.js"

const container = document.querySelector(".container");

const mainElement = document.createElement("main");
mainElement.classList.add("main-content");
container.appendChild(mainElement);

await fetch("http://localhost:8080/api/albums")
    .then(response => response.json())
    .then(albums => displayHomeView(albums))
    .then(albumsElement => container.appendChild(albumsElement))
    .catch(error => console.log(error));

container.append(createFooter());
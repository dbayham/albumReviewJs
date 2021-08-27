import { displaySingleAlbum, clearChildren } from "./displayAlbum.js";

const displayHomeView = function (albums) {
  const mainElement = document.querySelector(".main-content");
  const albumContainer = document.createElement("div");
  albumContainer.classList.add("album-container");
  const albumPhotos = document.createElement("main");
  albumPhotos.classList.add("photos");

  albumContainer.appendChild(albumPhotos);
  mainElement.appendChild(albumContainer);

  albums.forEach((album) => {
      const singleAlbum = document.createElement("div");
      singleAlbum.classList.add("item");

      const singleAlbumImage = document.createElement("img")
      singleAlbumImage.classList.add("album-cover");
      singleAlbumImage.src = album.imageUrl;

      singleAlbum.addEventListener("click", () => {
          displaySingleAlbum(album, albums);
      });

      singleAlbum.appendChild(singleAlbumImage);
      albumPhotos.appendChild(singleAlbum);
      albumContainer.appendChild(albumPhotos)
  });

  return mainElement;
};

export { displayHomeView };
//Handle change image by using input file
var userAvatarImage = document.querySelector("#file-upload");
var inputAvatar = document.querySelector(".avatar-link"); //Assign value for input has hidden type in form
userAvatarImage.addEventListener("change", (e) => {
  var tgt = e.target,
    files = tgt.files;

  // FileReader support
  if (FileReader && files && files.length) {
    var fr = new FileReader();
    fr.onload = function () {
      document.querySelector(".user-avatar-image").src = fr.result;
    };
    console.log(fr.result);
    fr.readAsDataURL(files[0]);
    inputAvatar.value = fr.result;
  }
  // Not supported
  else {
    // fallback -- perhaps submit the input to an iframe and temporarily store
    // them on the server until the user's session ends.
  }
});

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
//            inputAvatar.value = document.querySelector(".user-avatar-image").src;
        };

        fr.readAsDataURL(files[0]);
    }
//     Not supported
    else {
//     fallback -- perhaps submit the input to an iframe and temporarily store
//     them on the server until the user's session ends.
    }
    console.log(userAvatarImage.value);
    var uploadForm = document.querySelector(".form-file");
    uploadForm.submit();
});


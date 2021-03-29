function checkUrlParameter() {
    var url = window.location.href.toString();
    if (url.indexOf("?") === -1) {
        localStorage.clear();
    }
}
checkUrlParameter();
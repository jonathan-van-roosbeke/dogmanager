$(function(){       
    $('*[data-href]').click(function(){
        console.log(this);
        var a = this;
        var id = a.getElementsByClassName("id-chien")[0].innerHTML;

        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
        // Typical action to be performed when the document is ready:
         window.location.assign("EditionChien?id-chien="+ id);
        }
        };
        xhttp.open("GET", "EditionChien?id-chien="+ id, true);
        xhttp.send();
        return false;
    });
});
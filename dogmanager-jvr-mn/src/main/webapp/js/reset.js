function customReset()
{
    document.getElementById("puce-chien").value = "";
    document.getElementById("nom-chien").value = "";
    document.getElementById("age-chien").value = "";
}

function customDelete(myId)
{
	$.ajax({
		  method: "POST",
		  url: "delete",
		  data: { id: myId }
		})
		  .done(function( msg ) {
		    alert( "Votre chien a bien ete supprime");
		    window.location.assign("liste-utilisateur");
		  });
	
}

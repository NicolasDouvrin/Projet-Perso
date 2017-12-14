var type, activite, jeux, favportable, favfixe;

function _(x){
    return document.getElementById(x);
}

function processPhase1(){
    type = _("type").value;
    if (type.length>0) {
         _("phase1").style.display="none";
         _("phase2").style.display="block";
    }else{
    alert("Veuillez remplir le champs")
    }
}

function processPhase2(){
    activite = _("activite").value;
    if (activite.length>0) {
        if (activite=="jeu") {
            _("phase2").style.display = "none";
            _("phase3").style.display = "block";
        }else {
            if (type=="fixe") {
                _("phase2").style.display = "none";
                _("phase5").style.display = "block";
            } else{
                _("phase2").style.display = "none";
                _("phase4").style.display = "block";
            }
        }
    }else{
        alert("Veuillez remplir le champs")
    }
}

function processPhase3(){
    jeux = _("jeux").value;
    if (jeux.length>0) {
        if (type=="fixe") {
            _("phase3").style.display = "none";
            _("phase5").style.display = "block";
        } else{
            _("phase3").style.display = "none";
            _("phase4").style.display = "block";
        }
    }else{
        alert("Veuillez remplir le champs")
    }
}

function valider(){
    if(type=="fixe" && activite=="montage"){
        _("profil").style.display = "none";
        _("phase4").style.display = "none";
        _("phase5").style.display = "none";
        _("result1").style.display="block";
    }
    if(type=="fixe" && activite=="web" ){
        _("profil").style.display = "none";
        _("phase4").style.display = "none";
        _("phase5").style.display = "none";
        _("result2").style.display="block";
    }
    if(type=="fixe" && activite=="jeu" ){
        _("profil").style.display = "none";
        _("phase4").style.display = "none";
        _("phase5").style.display = "none";
        _("result3").style.display="block";
    }
    if(type=="portable" && activite=="montage"){
        _("profil").style.display = "none";
        _("phase4").style.display = "none";
        _("phase5").style.display = "none";
        _("result4").style.display="block";
    }
    if(type=="portable" && activite=="web" ){
        _("profil").style.display = "none";
        _("phase4").style.display = "none";
        _("phase5").style.display = "none";
        _("result5").style.display="block";
    }
    if(type=="portable" && activite=="jeu" ){
        _("profil").style.display = "none";
        _("phase4").style.display = "none";
        _("phase5").style.display = "none";
        _("result6").style.display="block";
    }
}



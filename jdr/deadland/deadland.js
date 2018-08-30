

var sac = [];
var nbPioche = 0;
var base = [{name:"blanc", nb:20, style:"white"}, {name:"bleu", nb:5, style:"blue"}, {name:"rouge", nb:10, style:"red"}] ;
var legendaire = {name:"legendaire", style:"yellow"};
var ids = {sac:"sac", inputleg:"ip-legendaire", histo:"histo-pioche"};

function init() {
	sac = [];
	nbPioche = 0;
	for (var i = 0; i < base.length; i++) {
		var obj = base[i];
		var count = obj.nb
		for (var j = 0; j < obj.nb; j++) {
			sac[sac.length]={name:obj.name, style:obj.style}
			
		}
	}
	var divhisto = getEl(ids.histo)
	if (divhisto.childNodes.length > 0) {
		divhisto.removeChild(divhisto.childNodes[0]);
	}
	shuffle(sac);
	sacaj();
}

function pick() {
	var pick = random(0, sac.length-1);
	return sac.splice(pick, 1)[0];
}


function pioche() {
	nbPioche++;
	var npi = 3;
	var picks = [];
	for (npi; npi > 0; npi--) {
		picks[picks.length] = pick();
	}

	sacaj();
	var divhisto = getEl(ids.histo)
	if (divhisto.childNodes.length == 0) {
		addNode(divhisto, "div");
	}
	
	childhisto = divhisto.childNodes[0];
	
	addTextNode(childhisto, "Joueur "+nbPioche+" pioche: ");
	
	for (var ii=0; ii < picks.length; ii++) {
		var p = addNode(childhisto, "span");
		p.style="color:"+picks[ii].style+";";
		addTextNode(p, picks[ii].name +" ");
	}
	addBrNode(childhisto);
}

function putleg() {
	var legnb = getEl(ids.inputleg).value;
	if (legnb <= 0) {
		return;
	}
	for (var j = 0; j < legnb; j++) {
		sac[sac.length]={name:legendaire.name, style:legendaire.style}
	}
	shuffle(sac);
	sacaj();
}


function sacaj() {
	var divsac = getEl(ids.sac)
	if (divsac.childNodes.length > 0) {
		divsac.removeChild(divsac.childNodes[0]);
	}
	
	var div = addNode(divsac, "div");
	
	for (var i=0; i < sac.length; i++) {
		var p = addNode(div, "span");
		p.style="color:"+sac[i].style+";";
		addTextNode(p, sac[i].name +" ");
	}
}
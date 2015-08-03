// COMmercial MONkey KI javaScript // HUHU

var listObjets = "[]";
var listObjetsCommerce = [];




/* Algo
 * 
 * 1 - détermine si la page est une page de commerce (si oui mettre un bouton dans la page qui déclenche le script)
 * 2 - si oui on parse le tableau du commerce pour
 * 		- obtenir le salaire + impot si on le trouve sinon initialisation 0
 * 		- lister les objets existant en faisant lien avec les objets référencé et ligne du tableau
 * 			Au moment de cette liste on réservera des id pour les différentes cellule supplémentaire
 * 		
 * 		- fur et a mesure que l'on rencontre ligne de type d'objet on garde l'impot si on le trouve sinon init 0
 * 3 - créé le tableau des impots au dessus du commerce
 * 4 - parcours les lignes du tableau pour ajouter les fonctions de calcul et la colonne qui va bien etc.
 * 		- case pour modifier prix
 * 		- case pour voir les données de gain
 * 5 - c'est fini
 *  
 * 
 * Option d'affichage :
 * 		- gain vente
 * 		- cout prod
 * 
 */





/*

	Premier passage on écrit tout avec les id et on enregistre dans le tableau.
	Au second passage on enregistre les listeners et tout.
	
	Ainsi au premier passage on a tout la structure des données
	Au second on met l'inteligence.




*/

/**
 * Fonction de calcul.
 */

/**
 * Calcul du gain lors d'une vente d'un produit fabriqué dans le commerce
 * 
 * @param pVente prix vente
 * @param cProd cout de production
 * @param nbProd nb produit par ut
 * @param iObj impot de l'objet
 * @returns {Number}
 */
function calculGainVente(pVente, cProd, nbProd, iObj) {
	var prix = pVente - cProd / nbProd;
	prix = calculPourcentage(prix, iObj);
	return prix;
}

/**
 * Calcul du gain lors de la vente d'un objet revendu après achat
 * 
 * @param pVente
 *            Prix de vente
 * @param pAchat
 *            Prix d'achat
 * @param iObj
 *            Impot sur l'objet
 * @returns {Number}
 */
function calculGainReVente(pVente, pAchat, iObj) {
	var prix = pVente - pAchat;
	prix = calculPourcentage(prix, iObj);
	return prix;
}

/**
 * Calcul du pourcentage en plus ou moins d'une valeur
 * 
 * @param val
 *            valeur
 * @param pourcent
 *            pourcentage
 * @param plus
 *            booleen pour le sens
 * @returns {Number}
 */
function calculPourcentage(val, pourcent, plus) {
	var result = val * (1 - parseInt(pourcent) / 100);

	if (plus != null && plus) {
		result = val * (1 + parseInt(pourcent) / 100);
	}

	return result;
}

/**
 * Calcul du cout de production d'objet
 * 
 * @param salaire
 * @param ut
 *            nombre d'unité de travail
 * @param tabPrixComposant
 *            tableau des cout de productions des composant.
 * @returns {Number}
 */
function calculCoutProd(salaire, ut, tabPrixComposant) {

	var result = salaire * ut;

	if (tabPrixComposant != null) {
		for (var i = 0; i < tabPrixComposant.length; i++) {
			result = parseInt(result) + parseInt(tabPrixComposant[i]);
		}
	}

	return result;
}




/**
 * Fonctions utilitaires Création de node, ajout de node. etc.
 *  *
 */

// raccourci
function getEl(id) {
	return window.document.getElementById(id);
}

/**
 * Fonction de base pour ajouter un noeud d'un type
 * 
 * @param NodeParent
 *            parent
 * @param typeNode
 *            type de noeud
 * @returns noeud créé
 */
function addNode(NodeParent, typeNode) {
	var node = document.createElement(typeNode);
	NodeParent.appendChild(node);
	return node;
}

/**
 * Ajout d'une node input text
 * 
 * @param NodeParent
 *            parent
 * @param id
 *            du noeur
 * @param valeur
 *            valeur
 * @param readO
 *            readonly
 * @returns {___anonymous574_577}
 */
function addInputNode(NodeParent, id, valeur, readO) {
	var node = addNode(NodeParent, "input");
	node.type = 'text';
	node.id = id;
	node.value = valeur;
	if (readO != null) {
		node.disabled = readO;
	}
	return node;
}

function addImgNode(NodeParent, src) {
	var node = addNode(NodeParent, "img");
	node.src = src;
	node.width = 32;
	node.height = 32;
	return node;
}

function addBrNode(NodeParent) {
	var node = addNode(NodeParent, "br");
}

function addTableNode(NodeParent) {
	var node = addNode(NodeParent, "table");
	return node;
}

function addTrNode(NodeParent) {
	var node = addNode(NodeParent, "tr");
	return node;
}
function addThNode(NodeParent) {
	var node = addNode(NodeParent, "th");
	return node;
}

function addTdNode(NodeParent) {
	var node = addNode(NodeParent, "td");
	return node;
}

function addNodeText(NodeParent, text) {
	var node = document.createTextNode(text);
	NodeParent.appendChild(node);
}
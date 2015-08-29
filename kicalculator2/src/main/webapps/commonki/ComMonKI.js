// ==UserScript==
// @name        ComMonKI
// @include     http://www.kraland.org/*
// @include     http://test.kraland.org/*
// @grant 		none
// @author Famine(794)
// @version 1.5
// ==/UserScript==

// COMmercial MONkey KI javaScript // HUHU

// OPTIONS A MODIFIER SI BESOIN
var valeurDefautImpot = 10; // valeur par defaut si impot non trouv�

var marchandageActive = true; // true/false affiche ou non le marchandage
var typeMarchandage = 'AchatVente'; // valeur possible : Achat, Vente ou AchatVente
var valeurDefautMarchandage = 10; // valeur par d�faut du marchandage

var fraude = false; // fraude fiscale activ�e ou non.

// NE PAS MODIFIER SI VOUS NE SAVEZ PAS CE QUE VOUS FAITES
// Liste des objets
var data = '[{"composants":[{"nomObjet":"Verre","nombre":1},{"nomObjet":"Plastique","nombre":2},{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Ordinateur","categorie":"�LECTRONIQUE","batiment":"�lectronique","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Ossements","categorie":"DIVERS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1},{"nomObjet":"Corde","nombre":1}],"nom":"Machine � Pomper","categorie":"OUTILS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":2,"charge":1,"niveau":3,"capacite":0},{"nom":"N?ud rose","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plastique","nombre":1}],"nom":"Cube Capsien","categorie":"DIVERS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":3,"charge":1,"niveau":1,"capacite":0},{"nom":"Cour","categorie":"�QUIPEMENT MAISONS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Grenade en plastique","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Cr�ne de D�mon","categorie":"DIVERS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Bois","nombre":1},{"nomObjet":"Acier","nombre":1}],"nom":"Bouclier","categorie":"ARMURES","batiment":"Armurerie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"nom":"Objet Inconnu","categorie":"DIVERS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"C�r�ale","nombre":1}],"nom":"Zubrowkra","categorie":"BOISSONS","batiment":"Restaurant","uniteTravail":1,"produitPar":3,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Plastique","nombre":1}],"nom":"�cran Magique Dukisse","categorie":"DIVERS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":3,"charge":1,"niveau":1,"capacite":0},{"nom":"wPhone 4000","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Bonnet de No�l","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Stage - Combat Contact","categorie":"STAGES","batiment":"�cole Sup�rieure","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1},{"nomObjet":"Cuir","nombre":2}],"nom":"Tambour","categorie":"MUSIQUE","batiment":"Quincaillerie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"nom":"Marionnette de chat pour ventriloque","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"L�gume","categorie":"NOURRITURE","batiment":"Ferme","uniteTravail":1,"produitPar":10,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"P�trole","nombre":1}],"nom":"�nergie (P�trole)","categorie":"�NERGIE","batiment":"Centrale Thermique","uniteTravail":1,"produitPar":2,"charge":1,"niveau":3,"capacite":0},{"nom":"Bouton Airp�","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":8},{"nomObjet":"Moteur","nombre":2},{"nomObjet":"Lance-Roquettes","nombre":1}],"nom":"Composant d\u0027Avion Militaire","categorie":"COMPOSANTS","batiment":"Base Militaire","uniteTravail":8,"produitPar":1,"charge":10,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1},{"nomObjet":"Corde","nombre":1}],"nom":"Ukulele","categorie":"MUSIQUE","batiment":"Quincaillerie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Pierre","nombre":2}],"nom":"Verre","categorie":"PRODUITS INTERM�DIAIRES","batiment":"Briqueterie","uniteTravail":1,"produitPar":2,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1}],"nom":"Vieille Clef","categorie":"CLEFS","uniteTravail":1,"produitPar":5,"charge":1,"niveau":1,"capacite":0},{"nom":"Bon d\u0027Etat - Paradigme Vert","categorie":"BONS D\u0027�TAT / LOTERIE","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact Pouvoir +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact Discr�tion +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":2},{"nomObjet":"Plastique","nombre":1},{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Moteur","categorie":"PRODUITS INTERM�DIAIRES","batiment":"Garage","uniteTravail":3,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Plastique","nombre":1},{"nomObjet":"Carte Electronique","nombre":1}],"nom":"T�l�phone Portable","categorie":"�LECTRONIQUE","batiment":"�lectronique","uniteTravail":1,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"nom":"Bouby","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":4},{"nomObjet":"Pneu","nombre":4},{"nomObjet":"Moteur","nombre":1},{"nomObjet":"Lance-Roquettes","nombre":1}],"nom":"Composant de V�hicule Militaire","categorie":"COMPOSANTS","batiment":"Base Militaire","uniteTravail":6,"produitPar":1,"charge":10,"niveau":3,"capacite":0},{"nom":"Stage - Informatique","categorie":"STAGES","batiment":"�cole Sup�rieure","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Pioche miniature de mineur kralandais","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Bateau dans une bouteille","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"P�trole","nombre":2}],"nom":"Caoutchouc","categorie":"PRODUITS INTERM�DIAIRES","batiment":"Raffinerie","uniteTravail":1,"produitPar":2,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Cuir","nombre":4},{"nomObjet":"Textile","nombre":2}],"nom":"Mobilier","categorie":"�QUIPEMENT MAISONS","batiment":"Tailleur","uniteTravail":3,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Yahourt Appleburry","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plastique","nombre":1}],"nom":"Paire de Boules Qui�s","categorie":"DIVERS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":3,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Acier","nombre":2}],"nom":"�p�e Courte","categorie":"ARMES DE CONTACT","batiment":"Armurerie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"nom":"Mouton","categorie":"ANIMAUX D\u0027�LEVAGE","batiment":"Enclos","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Vraie R�sine de D�mon Brun","categorie":"POTIONS MAGIQUES","batiment":"Alchimie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Fruit","nombre":5},{"nomObjet":"C�r�ale","nombre":5}],"nom":"Petit D�jeuner","categorie":"REPAS","batiment":"Restaurant","uniteTravail":1,"produitPar":10,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1}],"nom":"Cadenas","categorie":"�QUIPEMENT MAISONS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":2},{"nomObjet":"Pneu","nombre":2}],"nom":"V�lo","categorie":"V�HICULES","batiment":"Garage","uniteTravail":3,"produitPar":1,"charge":0,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Planche","nombre":10},{"nomObjet":"Moteur","nombre":3}],"nom":"Cargo","categorie":"BATEAUX","batiment":"Port","uniteTravail":5,"produitPar":1,"charge":60,"niveau":4,"capacite":0},{"nom":"Artefact Combat Contact +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":3},{"nomObjet":"Pneu","nombre":4},{"nomObjet":"Moteur","nombre":2}],"nom":"Voiture de Sport","categorie":"V�HICULES","batiment":"Garage","uniteTravail":6,"produitPar":1,"charge":0,"niveau":3,"capacite":0},{"nom":"Ration de Survie","categorie":"NOURRITURE","uniteTravail":1,"produitPar":2,"charge":1,"niveau":1,"capacite":0},{"nom":"Uranium","categorie":"MATI�RES PREMI�RES","batiment":"Mine de Fer","uniteTravail":1,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"Acier","nombre":2}],"nom":"Coffre-Fort","categorie":"�QUIPEMENT MAISONS","batiment":"Quincaillerie","uniteTravail":2,"produitPar":1,"charge":5,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Manuel de bricolage","categorie":"LIVRES","batiment":"Biblioth�que","uniteTravail":1,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Uranium","nombre":1}],"nom":"�nergie (Uranium)","categorie":"�NERGIE","batiment":"Centrale Thermique","uniteTravail":1,"produitPar":3,"charge":1,"niveau":4,"capacite":0},{"nom":"Briquet bleu","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact Pouvoirs +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Billet de Mus�e","categorie":"BONS D\u0027�TAT / LOTERIE","batiment":"Mus�e","uniteTravail":1,"produitPar":10,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Implant - M�decine","categorie":"IMPLANTS","batiment":"Clinique","uniteTravail":1,"produitPar":2,"charge":1,"niveau":4,"capacite":0},{"nom":"Ballot de Th�","categorie":"DIVERS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Briquet noir","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Cuir","nombre":1}],"nom":"Fronde","categorie":"ARMES DE TIR","batiment":"Armurerie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact Survie +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Stage - D�molition","categorie":"STAGES","batiment":"�cole Sup�rieure","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Bon d\u0027Etat - Conf�d�ration Libre","categorie":"BONS D\u0027�TAT / LOTERIE","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Implant - S�duction","categorie":"IMPLANTS","batiment":"Clinique","uniteTravail":1,"produitPar":2,"charge":1,"niveau":4,"capacite":0},{"nom":"Si�ge Sacr� de Naar","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Bon d\u0027Etat - Th�ocratie Seelienne","categorie":"BONS D\u0027�TAT / LOTERIE","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1},{"nomObjet":"Corde","nombre":1}],"nom":"St�thoscope","categorie":"OUTILS","batiment":"Quincaillerie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Textile","nombre":2}],"nom":"Punching-Ball","categorie":"DIVERS","batiment":"Tailleur","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Bois","nombre":1}],"nom":"B�ton","categorie":"ARMES DE CONTACT","batiment":"Armurerie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Verre","nombre":1},{"nomObjet":"Plastique","nombre":2},{"nomObjet":"Carte Electronique","nombre":1}],"nom":"T�l�vision","categorie":"�QUIPEMENT MAISONS","batiment":"�lectronique","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Plastique","nombre":1}],"nom":"Norgakra en Plastique","categorie":"DIVERS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":3,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"C�r�ale","nombre":1}],"nom":"Bi�re","categorie":"BOISSONS","batiment":"Restaurant","uniteTravail":1,"produitPar":10,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plastique","nombre":1}],"nom":"Badge Lib�re ta Libert�","categorie":"DIVERS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":5,"charge":1,"niveau":1,"capacite":0},{"nom":"Logique Brute","categorie":"MATI�RES PREMI�RES","batiment":"Puits de Logique Brute","uniteTravail":3,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":8},{"nomObjet":"Moteur","nombre":1},{"nomObjet":"Lance-Roquettes","nombre":1}],"nom":"Composant de Navire de Guerre","categorie":"COMPOSANTS","batiment":"Base Militaire","uniteTravail":6,"produitPar":2,"charge":10,"niveau":3,"capacite":0},{"nom":"Soin","categorie":"SERVICES","batiment":"Clinique","uniteTravail":1,"produitPar":2,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Bois","nombre":6},{"nomObjet":"Acier","nombre":6}],"nom":"Hallebarde","categorie":"ARMES DE CONTACT","batiment":"Armurerie","uniteTravail":6,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"Acier","nombre":2}],"nom":"Porte Blind�e","categorie":"�QUIPEMENT MAISONS","batiment":"Quincaillerie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"C�r�ale","nombre":2},{"nomObjet":"Viande","nombre":3}],"nom":"Hamburger","categorie":"REPAS","batiment":"Restaurant","uniteTravail":1,"produitPar":10,"charge":1,"niveau":2,"capacite":0},{"nom":"Insigne Militaire Conf�d�r�","categorie":"DIVERS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact Force +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Carte de membre redstarlinien","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1}],"nom":"Acier","categorie":"PRODUITS INTERM�DIAIRES","batiment":"Forge","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Laine","nombre":2}],"nom":"Manteau en Poils de Yak","categorie":"V�TEMENTS ET ACCESSOIRES","batiment":"Tailleur","uniteTravail":2,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"nom":"Artefact Confort +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"L�gume","nombre":8},{"nomObjet":"Viande","nombre":4}],"nom":"Repas avec Viande","categorie":"REPAS","batiment":"Restaurant","uniteTravail":1,"produitPar":10,"charge":1,"niveau":3,"capacite":0},{"nom":"Stage - Commerce","categorie":"STAGES","batiment":"�cole Sup�rieure","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"T�teux Parasite","categorie":"ANIMAUX D\u0027�LEVAGE","batiment":"Enclos","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Acier","nombre":1}],"nom":"Parapluie Blind�","categorie":"DIVERS","batiment":"Armurerie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Courtisane","categorie":"SERVICES","batiment":"Restaurant","uniteTravail":2,"produitPar":2,"charge":1,"niveau":4,"capacite":0},{"nom":"Insigne Militaire Palladionaute","categorie":"DIVERS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Briquet mauve","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Fruit","nombre":1}],"nom":"Jus de Fruit","categorie":"BOISSONS","batiment":"Restaurant","uniteTravail":1,"produitPar":10,"charge":1,"niveau":1,"capacite":0},{"nom":"Cheval Dress�","categorie":"V�HICULES","uniteTravail":2,"produitPar":1,"charge":10,"niveau":1,"capacite":0},{"nom":"Pomme Transg�nique","categorie":"NOURRITURE","batiment":"Ferme","uniteTravail":1,"produitPar":10,"charge":1,"niveau":1,"capacite":0},{"nom":"Gousse d\u0027Ail","categorie":"NOURRITURE","batiment":"Ferme","uniteTravail":1,"produitPar":10,"charge":1,"niveau":1,"capacite":0},{"nom":"Clef de Bunker","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"String de chastet�","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":10},{"nomObjet":"Moteur","nombre":8}],"nom":"Jet Priv�","categorie":"AVIONS","batiment":"A�roport","uniteTravail":10,"produitPar":1,"charge":5,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"Textile","nombre":2}],"nom":"Panoplie de Discr�tion","categorie":"V�TEMENTS ET ACCESSOIRES","batiment":"Tailleur","uniteTravail":2,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"nom":"Sbleune rouge","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Bois","nombre":3},{"nomObjet":"Acier","nombre":3}],"nom":"Hache","categorie":"ARMES DE CONTACT","batiment":"Armurerie","uniteTravail":3,"produitPar":1,"charge":2,"niveau":2,"capacite":0},{"nom":"Casque de Clone Warrior 4000","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"�p�e Longue","nombre":1},{"nomObjet":"Anneau en Or","nombre":1}],"nom":"�p�e Magique","categorie":"ARMES DE CONTACT","uniteTravail":7,"produitPar":1,"charge":2,"niveau":1,"capacite":0},{"nom":"Artefact Gestion +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"P�trole","nombre":2}],"nom":"Savonnette","categorie":"DIVERS","batiment":"Raffinerie","uniteTravail":1,"produitPar":5,"charge":1,"niveau":2,"capacite":0},{"nom":"�nergie (Homme)","categorie":"�NERGIE","batiment":"Centrale Thermique","uniteTravail":2,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Gros bouton rose","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Essence","nombre":10}],"nom":"Voyage en Bateau","categorie":"SERVICES","batiment":"Port","uniteTravail":1,"produitPar":2,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Cuir","nombre":2},{"nomObjet":"M�tal","nombre":1}],"nom":"Chaussures de Combat","categorie":"V�TEMENTS ET ACCESSOIRES","batiment":"Tailleur","uniteTravail":3,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"?uf Mutant","categorie":"NOURRITURE","uniteTravail":1,"produitPar":4,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Laine","nombre":1}],"nom":"Karash en Peluche","categorie":"DIVERS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":2,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"C�r�ale","nombre":1}],"nom":"Alcool de Cactus","categorie":"BOISSONS","batiment":"Restaurant","uniteTravail":1,"produitPar":3,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"C�r�ale","nombre":1}],"nom":"Th�","categorie":"BOISSONS","batiment":"Restaurant","uniteTravail":1,"produitPar":10,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Uranium","nombre":6},{"nomObjet":"Moteur","nombre":1},{"nomObjet":"Missile","nombre":1}],"nom":"Missile Nucl�aire","categorie":"ARMEMENTS DIVERS","batiment":"Base Militaire","uniteTravail":4,"produitPar":1,"charge":25,"niveau":4,"capacite":0},{"nom":"Plante carnivore en plastique","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Peluche troll","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Canard en Plastique de Chambou","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Verre","nombre":1},{"nomObjet":"Plastique","nombre":1}],"nom":"Jumelles","categorie":"OUTILS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"C�r�ale","nombre":1}],"nom":"Whisky","categorie":"BOISSONS","batiment":"Restaurant","uniteTravail":1,"produitPar":3,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":4}],"nom":"Acide","categorie":"M�DICAMENTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Implant - Survie","categorie":"IMPLANTS","batiment":"Clinique","uniteTravail":1,"produitPar":2,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"L�gume","nombre":8},{"nomObjet":"Viande","nombre":4}],"nom":"Pizza","categorie":"REPAS","batiment":"Restaurant","uniteTravail":1,"produitPar":10,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Plante Magique","nombre":4}],"nom":"Poudre d\u0027Escampette","categorie":"POTIONS MAGIQUES","batiment":"Alchimie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Fenouil","categorie":"NOURRITURE","batiment":"Ferme","uniteTravail":1,"produitPar":10,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plante Magique","nombre":2}],"nom":"�lixir de Vision","categorie":"POTIONS MAGIQUES","batiment":"Alchimie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"nom":"Bon d\u0027Etat - Royaume de Ruthv�nie","categorie":"BONS D\u0027�TAT / LOTERIE","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Plante Magique","categorie":"PLANTES","batiment":"Ferme","uniteTravail":1,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"nom":"Myosotis","categorie":"PLANTES","batiment":"Ferme","uniteTravail":1,"produitPar":2,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Fruit","nombre":1}],"nom":"Pourprovilloise","categorie":"BOISSONS","batiment":"Restaurant","uniteTravail":1,"produitPar":3,"charge":1,"niveau":3,"capacite":0},{"nom":"Jasmin","categorie":"PLANTES","batiment":"Ferme","uniteTravail":1,"produitPar":2,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1},{"nomObjet":"Plastique","nombre":1}],"nom":"Carte Electronique","categorie":"PRODUITS INTERM�DIAIRES","batiment":"�lectronique","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Bruy�re","categorie":"PLANTES","batiment":"Ferme","uniteTravail":1,"produitPar":2,"charge":1,"niveau":2,"capacite":0},{"nom":"L\u0027Art de Gouverner Elmer Caps","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Acier","nombre":2}],"nom":"Casque","categorie":"ARMURES","batiment":"Armurerie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Stage - Falsification","categorie":"STAGES","batiment":"�cole Sup�rieure","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Champignonz","categorie":"NOURRITURE","batiment":"Ferme","uniteTravail":1,"produitPar":4,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plastique","nombre":1}],"nom":"Mini-Lexpagette Articul�e","categorie":"DIVERS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":3,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Or","nombre":10},{"nomObjet":"M�tal","nombre":3}],"nom":"Collier en Or","categorie":"BIJOUX","batiment":"Bijouterie","uniteTravail":4,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"nom":"Artefact Moral +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Clone d�Ernst Blofeld II","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Acier","nombre":1}],"nom":"Pioche","categorie":"OUTILS","batiment":"Quincaillerie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"nom":"Slip neuf sous blister 1er Elu","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Bon d\u0027Etat - Kraland","categorie":"BONS D\u0027�TAT / LOTERIE","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Cuir","categorie":"MATI�RES PREMI�RES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1},{"nomObjet":"Anneau en Or","nombre":1}],"nom":"Baguette Magique","categorie":"OBJETS MAGIQUES","batiment":"Alchimie","uniteTravail":3,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Masque �co-terroriste (no 2)","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Vache","categorie":"ANIMAUX D\u0027�LEVAGE","batiment":"Enclos","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Philosophie Syncr�tique de Franck Mysti","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact Utilisable","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Ocarina","categorie":"MUSIQUE","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Faux Papiers","categorie":"LIVRES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Boule � facettes","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact Falsification +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Verre","nombre":1},{"nomObjet":"Plastique","nombre":2},{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Cam�ra","categorie":"�QUIPEMENT MAISONS","batiment":"�lectronique","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":2},{"nomObjet":"Collier en Or","nombre":1}],"nom":"Collier de Protection","categorie":"OBJETS MAGIQUES","batiment":"Alchimie","uniteTravail":6,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"nom":"Pi�ce Porte-Bonheur","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact Max Confort +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Implant - Discr�tion","categorie":"IMPLANTS","batiment":"Clinique","uniteTravail":1,"produitPar":2,"charge":1,"niveau":4,"capacite":0},{"nom":"Jambe de bois de Woodenleg","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1},{"nomObjet":"Textile","nombre":2}],"nom":"Filet de p�che","categorie":"V�TEMENTS ET ACCESSOIRES","batiment":"Tailleur","uniteTravail":1,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Tambouille","categorie":"REPAS","batiment":"Prison","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":4}],"nom":"M�dicament Anti-Elm�risme","categorie":"M�DICAMENTS","batiment":"Clinique","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Briquet gris","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Implant - D�molition","categorie":"IMPLANTS","batiment":"Clinique","uniteTravail":1,"produitPar":2,"charge":1,"niveau":4,"capacite":0},{"nom":"Flocon de neige en cristal","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Verre","nombre":2},{"nomObjet":"Anneau en Or","nombre":2}],"nom":"Globe de Cristal","categorie":"OBJETS MAGIQUES","batiment":"Alchimie","uniteTravail":5,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"nom":"Masque �co-terroriste (no 1)","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Implant - �loquence","categorie":"IMPLANTS","batiment":"Clinique","uniteTravail":1,"produitPar":2,"charge":1,"niveau":4,"capacite":0},{"nom":"Insigne Militaire Paradigmien","categorie":"DIVERS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Carte membre de l�Empire Rose Recharg�","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Pierre","nombre":2}],"nom":"Brique","categorie":"PRODUITS INTERM�DIAIRES","batiment":"Briqueterie","uniteTravail":1,"produitPar":2,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":2},{"nomObjet":"Plastique","nombre":1}],"nom":"Extincteur","categorie":"�QUIPEMENT MAISONS","batiment":"Quincaillerie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Discussion Philosophique","categorie":"SERVICES","batiment":"Biblioth�que","uniteTravail":1,"produitPar":2,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Fruit","nombre":5}],"nom":"Glace","categorie":"REPAS","batiment":"Restaurant","uniteTravail":1,"produitPar":10,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Fruit","nombre":5}],"nom":"Loukoum","categorie":"NOURRITURE","batiment":"Restaurant","uniteTravail":1,"produitPar":10,"charge":1,"niveau":1,"capacite":0},{"nom":"Rose","categorie":"PLANTES","batiment":"Ferme","uniteTravail":1,"produitPar":2,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1},{"nomObjet":"Poudre Noire","nombre":1}],"nom":"Roquette","categorie":"MUNITIONS \u0026 EXPLOSIFS","batiment":"Base Militaire","uniteTravail":1,"produitPar":5,"charge":1,"niveau":3,"capacite":0},{"nom":"Artefact Baratin +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Bois","nombre":1},{"nomObjet":"M�tal","nombre":1}],"nom":"Fl�che","categorie":"MUNITIONS \u0026 EXPLOSIFS","batiment":"Armurerie","uniteTravail":1,"produitPar":10,"charge":1,"niveau":2,"capacite":0},{"nom":"Artefact Nourriture +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Recueil des Slogans du Palladium","categorie":"LIVRES","batiment":"Biblioth�que","uniteTravail":1,"produitPar":4,"charge":1,"niveau":2,"capacite":0},{"nom":"Stage - �loquence","categorie":"STAGES","batiment":"�cole Sup�rieure","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Portrait de la Grande D�esse","categorie":"LIVRES","batiment":"Biblioth�que","uniteTravail":1,"produitPar":2,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":4},{"nomObjet":"Verre","nombre":6},{"nomObjet":"Carte Electronique","nombre":6}],"nom":"D�fense Laser","categorie":"�QUIPEMENT MAISONS","batiment":"�lectronique","uniteTravail":4,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"nom":"Insigne Militaire Seelien","categorie":"DIVERS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"P�re Vert, Grinch","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"L�gume","nombre":1}],"nom":"Tequila","categorie":"BOISSONS","batiment":"Restaurant","uniteTravail":1,"produitPar":3,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"C�r�ale","nombre":1}],"nom":"Pikron","categorie":"BOISSONS","batiment":"Restaurant","uniteTravail":1,"produitPar":5,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Planche","nombre":2}],"nom":"Kayak","categorie":"BATEAUX","batiment":"Port","uniteTravail":1,"produitPar":1,"charge":0,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":2},{"nomObjet":"Plastique","nombre":1}],"nom":"R�servoir Suppl�mentaire","categorie":"�QUIPEMENTS DE V�HICULES","batiment":"Garage","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Verre","nombre":1}],"nom":"Boule � Neige de Tokyo-3","categorie":"DIVERS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":3,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Bois","nombre":3},{"nomObjet":"Acier","nombre":8}],"nom":"Mitraillette","categorie":"ARMES DE TIR","batiment":"Armurerie","uniteTravail":8,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"Verre","nombre":1},{"nomObjet":"Plastique","nombre":2},{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Localisateur","categorie":"�LECTRONIQUE","batiment":"�lectronique","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Colis","categorie":"COURRIER","batiment":"Biblioth�que","uniteTravail":1,"produitPar":2,"charge":1,"niveau":3,"capacite":0},{"nom":"Cactus en pot","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Palladollar en Chocolat","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plastique","nombre":1}],"nom":"Fausse Main","categorie":"V�TEMENTS ET ACCESSOIRES","batiment":"Chapiteau","uniteTravail":2,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Stage - Observation","categorie":"STAGES","batiment":"�cole Sup�rieure","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plastique","nombre":1}],"nom":"Bo�te Kra20Kra","categorie":"DIVERS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":3,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Implant - Combat Mains Nues","categorie":"IMPLANTS","batiment":"Clinique","uniteTravail":1,"produitPar":2,"charge":1,"niveau":4,"capacite":0},{"nom":"Stage - Combat Mains Nues","categorie":"STAGES","batiment":"�cole Sup�rieure","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Bois","nombre":2}],"nom":"Planche","categorie":"PRODUITS INTERM�DIAIRES","batiment":"Scierie","uniteTravail":1,"produitPar":2,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"P�trole","nombre":1}],"nom":"Essence","categorie":"�NERGIE","batiment":"Raffinerie","uniteTravail":1,"produitPar":250,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Fruit","nombre":1}],"nom":"Vin Pourpre","categorie":"BOISSONS","batiment":"Restaurant","uniteTravail":1,"produitPar":3,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Laine","nombre":1}],"nom":"Textile","categorie":"PRODUITS INTERM�DIAIRES","batiment":"Tailleur","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Implant - Commerce","categorie":"IMPLANTS","batiment":"Clinique","uniteTravail":1,"produitPar":2,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1},{"nomObjet":"Corde","nombre":1}],"nom":"Guitare","categorie":"MUSIQUE","batiment":"Quincaillerie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Journal","categorie":"LIVRES","batiment":"Biblioth�que","uniteTravail":1,"produitPar":8,"charge":1,"niveau":1,"capacite":0},{"nom":"Chenille en Chiffon","categorie":"DIVERS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":2},{"nomObjet":"Cuir","nombre":2}],"nom":"Valise","categorie":"V�TEMENTS ET ACCESSOIRES","batiment":"Tailleur","uniteTravail":2,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Implant - Organisation","categorie":"IMPLANTS","batiment":"Clinique","uniteTravail":1,"produitPar":2,"charge":1,"niveau":4,"capacite":0},{"nom":"Sbleune jaune","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Petite Culotte Sacr�e","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Bois","nombre":5},{"nomObjet":"Acier","nombre":4}],"nom":"Fusil","categorie":"ARMES DE TIR","batiment":"Armurerie","uniteTravail":6,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"nom":"Pinceau de peinture Rose","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Fourchette du Go�teur Royal","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact de T�l�portation","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":4},{"nomObjet":"Pneu","nombre":4},{"nomObjet":"Moteur","nombre":1}],"nom":"Voiture","categorie":"V�HICULES","batiment":"Garage","uniteTravail":4,"produitPar":1,"charge":5,"niveau":2,"capacite":0},{"nom":"Tr�sor","categorie":"MATI�RES PREMI�RES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Jeu de Cartes","categorie":"LIVRES","batiment":"Biblioth�que","uniteTravail":1,"produitPar":3,"charge":1,"niveau":2,"capacite":0},{"nom":"Artefact Intelligence +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":4}],"nom":"M�dicament Anti-Paralysie","categorie":"M�DICAMENTS","batiment":"Clinique","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Plante Magique","nombre":2}],"nom":"Potion Neutralisante","categorie":"POTIONS MAGIQUES","batiment":"Alchimie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"nom":"Briquet brun","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":2},{"nomObjet":"Anneau en Or","nombre":2}],"nom":"Bracelet de Force","categorie":"OBJETS MAGIQUES","batiment":"Alchimie","uniteTravail":6,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"Fruit","nombre":1}],"nom":"Liqueur de Banane","categorie":"BOISSONS","batiment":"Restaurant","uniteTravail":1,"produitPar":3,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":5}],"nom":"Gaz Lacrymog�ne","categorie":"M�DICAMENTS","batiment":"Clinique","uniteTravail":3,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Nuisette de Disco","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact Charme +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Couronne de Ruthv�nie","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plastique","nombre":1}],"nom":"Banane Sauteuse","categorie":"DIVERS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Ecrou de la machine Krapulax","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Cuir","nombre":2},{"nomObjet":"Papier","nombre":1}],"nom":"Manuel des Myst�res","categorie":"LIVRES","batiment":"Biblioth�que","uniteTravail":3,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"nom":"Artefact Observation +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Fleur �ternelle","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Vieille Godasse","categorie":"DIVERS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Codex Evgueni","categorie":"LIVRES","batiment":"Biblioth�que","uniteTravail":1,"produitPar":4,"charge":1,"niveau":2,"capacite":0},{"nom":"Petit Papa No�l du D�sert","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Kit-�-ondes","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Textile","nombre":1}],"nom":"Uniforme Warrior 3000","categorie":"V�TEMENTS ET ACCESSOIRES","batiment":"Tailleur","uniteTravail":1,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"nom":"Stage - Discr�tion","categorie":"STAGES","batiment":"�cole Sup�rieure","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Textile","nombre":10},{"nomObjet":"Moteur","nombre":1}],"nom":"Montgolfi�re","categorie":"AVIONS","batiment":"A�roport","uniteTravail":4,"produitPar":1,"charge":0,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Fleur","nombre":2}],"nom":"Shampoing Gor�al","categorie":"V�TEMENTS ET ACCESSOIRES","batiment":"Bijouterie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Laine","nombre":1}],"nom":"Ours en Peluche","categorie":"DIVERS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":3,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Lettre d\u0027Auguste � Auguste","categorie":"COURRIER","uniteTravail":1,"produitPar":4,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1}],"nom":"Harmonica","categorie":"MUSIQUE","batiment":"Quincaillerie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Armure d\u0027Or","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":2,"niveau":1,"capacite":0},{"nom":"Coffre","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":3,"niveau":1,"capacite":0},{"nom":"Poisson Exceptionnel","categorie":"NOURRITURE","uniteTravail":1,"produitPar":2,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Fleur","nombre":5}],"nom":"Peinture Viridienne","categorie":"V�TEMENTS ET ACCESSOIRES","batiment":"Bijouterie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"nom":"Manuscrit Original de Banshee!!!","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1},{"nomObjet":"Poudre Noire","nombre":1}],"nom":"Balle","categorie":"MUNITIONS \u0026 EXPLOSIFS","batiment":"Armurerie","uniteTravail":1,"produitPar":10,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":4}],"nom":"Poison Lent","categorie":"M�DICAMENTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Stage - S�duction","categorie":"STAGES","batiment":"�cole Sup�rieure","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Plante M�dicinale","categorie":"PLANTES","batiment":"Ferme","uniteTravail":1,"produitPar":2,"charge":1,"niveau":3,"capacite":0},{"nom":"Marqueur poisse","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":4}],"nom":"M�dicament Anti-D�pression","categorie":"M�DICAMENTS","batiment":"Clinique","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Ovule Sacr�","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Anneaux de Couleur","categorie":"DIVERS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact Max Nourriture +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Oiseau Rare","categorie":"NOURRITURE","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"L�gume","nombre":1}],"nom":"Alcool de Patates","categorie":"BOISSONS","batiment":"Restaurant","uniteTravail":1,"produitPar":3,"charge":1,"niveau":3,"capacite":0},{"nom":"Artefact Combat Mains Nues +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plastique","nombre":1}],"nom":"Tchou R�leur","categorie":"DIVERS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":3,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":4}],"nom":"Poison","categorie":"M�DICAMENTS","batiment":"Clinique","uniteTravail":1,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"nom":"Clef du Coffre","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Textile","nombre":1}],"nom":"V�tement Chic","categorie":"V�TEMENTS ET ACCESSOIRES","batiment":"Tailleur","uniteTravail":2,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"C�r�ale","nombre":1}],"nom":"Liqueur Moldave","categorie":"BOISSONS","batiment":"Restaurant","uniteTravail":1,"produitPar":3,"charge":1,"niveau":3,"capacite":0},{"nom":"Or","categorie":"MATI�RES PREMI�RES","batiment":"Mine d\u0027Or","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":4}],"nom":"M�dicament Anti-Drogue","categorie":"M�DICAMENTS","batiment":"Clinique","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Livre Saint","categorie":"LIVRES","batiment":"Biblioth�que","uniteTravail":1,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"B�ton de V�rit�","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"La Perfection � l��tat rose","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Livre","categorie":"LIVRES","batiment":"Biblioth�que","uniteTravail":1,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Langue de Bolo Polo","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"B�cher portatif","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":4}],"nom":"M�dicament Anti-Stress","categorie":"M�DICAMENTS","batiment":"Clinique","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Pierre","nombre":2}],"nom":"Sculpture","categorie":"DIVERS","uniteTravail":4,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact D�molition +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"C�r�ale","nombre":1}],"nom":"Th� du Grand Jardin","categorie":"BOISSONS","batiment":"Restaurant","uniteTravail":1,"produitPar":10,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Enveloppe","categorie":"COURRIER","batiment":"Biblioth�que","uniteTravail":1,"produitPar":4,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"C�r�ale","nombre":1}],"nom":"Shlibuvsky","categorie":"BOISSONS","batiment":"Restaurant","uniteTravail":1,"produitPar":3,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Acier","nombre":5}],"nom":"Armature Antisismique","categorie":"�QUIPEMENT MAISONS","batiment":"Quincaillerie","uniteTravail":5,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"nom":"Jonquille","categorie":"PLANTES","batiment":"Ferme","uniteTravail":1,"produitPar":2,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":9},{"nomObjet":"Pneu","nombre":6},{"nomObjet":"Moteur","nombre":2}],"nom":"Camion","categorie":"V�HICULES","batiment":"Garage","uniteTravail":9,"produitPar":1,"charge":20,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"Fleur","nombre":1}],"nom":"Huile de Massage","categorie":"V�TEMENTS ET ACCESSOIRES","batiment":"Bijouterie","uniteTravail":1,"produitPar":3,"charge":1,"niveau":2,"capacite":0},{"nom":"Boule de No�l de l�Empire Rose","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":8},{"nomObjet":"Poudre Noire","nombre":3}],"nom":"Lance-Roquettes","categorie":"ARMES DE TIR","batiment":"Base Militaire","uniteTravail":8,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"nom":"Bouteille de Gontrand de la Mortandi�re","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Collection de Cartes Bish�nens","categorie":"LIVRES","batiment":"Biblioth�que","uniteTravail":1,"produitPar":3,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1}],"nom":"Rasoir","categorie":"ARMES DE CONTACT","batiment":"Quincaillerie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":4}],"nom":"Virus","categorie":"M�DICAMENTS","batiment":"Clinique","uniteTravail":2,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"nom":"Poisson","categorie":"NOURRITURE","uniteTravail":1,"produitPar":10,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Bois","nombre":2},{"nomObjet":"Cuir","nombre":1}],"nom":"Arc","categorie":"ARMES DE TIR","batiment":"Armurerie","uniteTravail":3,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"nom":"Poup�e gonflable M�re No�l","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1},{"nomObjet":"Poudre Noire","nombre":1}],"nom":"Bombe","categorie":"MUNITIONS \u0026 EXPLOSIFS","batiment":"Armurerie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Carotte des glaces","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Planche","nombre":1}],"nom":"Radeau","categorie":"BATEAUX","uniteTravail":2,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Planche","nombre":10},{"nomObjet":"Textile","nombre":6}],"nom":"Caravelle","categorie":"BATEAUX","batiment":"Port","uniteTravail":5,"produitPar":1,"charge":10,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"Bois","nombre":4},{"nomObjet":"Cuir","nombre":1}],"nom":"Arc Long","categorie":"ARMES DE TIR","batiment":"Armurerie","uniteTravail":4,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"nom":"Bois","categorie":"MATI�RES PREMI�RES","batiment":"Production de Bois","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Fleur des Glaces","categorie":"PLANTES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Action Palladium Corporation","categorie":"BONS D\u0027�TAT / LOTERIE","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Pierre","nombre":2},{"nomObjet":"Anneau en Or","nombre":2}],"nom":"Arcane de la Connaissance","categorie":"OBJETS MAGIQUES","batiment":"Alchimie","uniteTravail":6,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"L�gume","nombre":8},{"nomObjet":"Viande","nombre":4}],"nom":"Plat de Spaghettis","categorie":"REPAS","batiment":"Restaurant","uniteTravail":1,"produitPar":10,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Pierre","nombre":1}],"nom":"Caillou","categorie":"PRODUITS INTERM�DIAIRES","batiment":"Prison","uniteTravail":1,"produitPar":10,"charge":1,"niveau":1,"capacite":0},{"nom":"Collier � clochette","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact Soins +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Cuir","nombre":2},{"nomObjet":"M�tal","nombre":1}],"nom":"Patins � Glace","categorie":"V�TEMENTS ET ACCESSOIRES","batiment":"Tailleur","uniteTravail":3,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Cuir","nombre":2}],"nom":"Fouet","categorie":"ARMES DE TIR","batiment":"Armurerie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Cadeau de No�l","categorie":"DIVERS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Billet de Loterie","categorie":"BONS D\u0027�TAT / LOTERIE","batiment":"Restaurant","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Unaussprechlichen Strukturen von Shinsei","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"�puration","categorie":"SERVICES","batiment":"Station d\u0027�puration","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Implant - Observation","categorie":"IMPLANTS","batiment":"Clinique","uniteTravail":1,"produitPar":2,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"C�r�ale","nombre":1}],"nom":"Caf�","categorie":"BOISSONS","batiment":"Restaurant","uniteTravail":1,"produitPar":10,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":2}],"nom":"Cigare","categorie":"DIVERS","batiment":"Alchimie","uniteTravail":1,"produitPar":4,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Plante Magique","nombre":1},{"nomObjet":"Papier","nombre":1}],"nom":"Parchemin","categorie":"OBJETS MAGIQUES","uniteTravail":2,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Prostitu�","categorie":"SERVICES","batiment":"Restaurant","uniteTravail":1,"produitPar":2,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":4}],"nom":"M�dicament Anti-Mystiphr�nie","categorie":"M�DICAMENTS","batiment":"Clinique","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":9},{"nomObjet":"Pneu","nombre":6},{"nomObjet":"Moteur","nombre":2}],"nom":"Bus","categorie":"V�HICULES","batiment":"Garage","uniteTravail":9,"produitPar":1,"charge":5,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"Or","nombre":5},{"nomObjet":"M�tal","nombre":1}],"nom":"Anneau en Or","categorie":"BIJOUX","batiment":"Bijouterie","uniteTravail":3,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Petit Livre Rouge de Red*Star","categorie":"LIVRES","batiment":"Biblioth�que","uniteTravail":1,"produitPar":4,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Livre de Comptes","categorie":"LIVRES","batiment":"Biblioth�que","uniteTravail":1,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Tarte � la Cr�me Enchant�e","categorie":"NOURRITURE","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact M�decine +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Fruit","nombre":2}],"nom":"Bonbon","categorie":"NOURRITURE","batiment":"Restaurant","uniteTravail":1,"produitPar":10,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact Consommable","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Laine","categorie":"MATI�RES PREMI�RES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Viande","categorie":"NOURRITURE","uniteTravail":1,"produitPar":5,"charge":1,"niveau":1,"capacite":0},{"nom":"Nounours Blofeld II","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact Informatique +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Implant - Falsification","categorie":"IMPLANTS","batiment":"Clinique","uniteTravail":1,"produitPar":2,"charge":1,"niveau":4,"capacite":0},{"nom":"Stage - Foi","categorie":"STAGES","batiment":"�cole Sup�rieure","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Planche","nombre":1}],"nom":"Porte Barricad�e","categorie":"�QUIPEMENT MAISONS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Bois","nombre":2}],"nom":"�nergie (Bois)","categorie":"�NERGIE","batiment":"Centrale Thermique","uniteTravail":1,"produitPar":3,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Manuel de Baratin","categorie":"LIVRES","batiment":"Biblioth�que","uniteTravail":1,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1},{"nomObjet":"Verre","nombre":1}],"nom":"Montre","categorie":"�LECTRONIQUE","batiment":"�lectronique","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Plan de Cambrousse","categorie":"LIVRES","batiment":"Biblioth�que","uniteTravail":1,"produitPar":4,"charge":1,"niveau":2,"capacite":0},{"nom":"Casque de Saint-Evgueni","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Stage - Vol","categorie":"STAGES","batiment":"�cole Sup�rieure","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plante Magique","nombre":2}],"nom":"Philtre d\u0027Amour","categorie":"POTIONS MAGIQUES","batiment":"Alchimie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Plastique","nombre":1}],"nom":"Casque de Chantier","categorie":"OUTILS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":4}],"nom":"Drogue","categorie":"M�DICAMENTS","batiment":"","uniteTravail":2,"produitPar":4,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"P�trole","nombre":1},{"nomObjet":"Verre","nombre":1}],"nom":"Trousse de Maquillage","categorie":"V�TEMENTS ET ACCESSOIRES","batiment":"Tailleur","uniteTravail":2,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1},{"nomObjet":"Verre","nombre":2}],"nom":"Mat�riel de Faussaire","categorie":"OUTILS","batiment":"Quincaillerie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":4}],"nom":"Vaccin","categorie":"M�DICAMENTS","batiment":"Clinique","uniteTravail":1,"produitPar":2,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Plastique","nombre":1}],"nom":"Canard en Plastique","categorie":"DIVERS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":3,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact Autres Effets +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1}],"nom":"Clef Vierge","categorie":"OUTILS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":5,"charge":1,"niveau":1,"capacite":0},{"nom":"Canard de Bouletie","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Cheval","categorie":"ANIMAUX D\u0027�LEVAGE","batiment":"Enclos","uniteTravail":1,"produitPar":1,"charge":10,"niveau":1,"capacite":0},{"nom":"Trait� de Propri�t� du Niarkalistan","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Bois","nombre":2},{"nomObjet":"Acier","nombre":2}],"nom":"Revolver","categorie":"ARMES DE TIR","batiment":"Armurerie","uniteTravail":4,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"L�gume","nombre":10}],"nom":"Soupe Populaire","categorie":"REPAS","batiment":"Temple Nabla","uniteTravail":1,"produitPar":15,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Pierre","nombre":1},{"nomObjet":"Anneau en Or","nombre":1}],"nom":"Repoussoir � Monstres","categorie":"OBJETS MAGIQUES","batiment":"Alchimie","uniteTravail":3,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Dark bougie naariste","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Fausse Moustache","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Essence","nombre":10}],"nom":"Voyage en Train","categorie":"SERVICES","batiment":"Gare","uniteTravail":1,"produitPar":2,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact Foi +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"C�r�ale","categorie":"NOURRITURE","batiment":"Ferme","uniteTravail":1,"produitPar":10,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Bois","nombre":1},{"nomObjet":"Pierre","nombre":1}],"nom":"Poudre Noire","categorie":"PRODUITS INTERM�DIAIRES","batiment":"Armurerie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Prostitu�e","categorie":"SERVICES","batiment":"Restaurant","uniteTravail":1,"produitPar":2,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"Verre","nombre":1},{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Lunette de Vis�e","categorie":"�LECTRONIQUE","batiment":"�lectronique","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1},{"nomObjet":"Corde","nombre":1}],"nom":"Canne � P�che","categorie":"OUTILS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Lettre","categorie":"COURRIER","batiment":"Biblioth�que","uniteTravail":1,"produitPar":4,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Implant - Pouvoir","categorie":"IMPLANTS","batiment":"Clinique","uniteTravail":1,"produitPar":2,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Implant - Informatique","categorie":"IMPLANTS","batiment":"Clinique","uniteTravail":1,"produitPar":2,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"C�r�ale","nombre":10}],"nom":"Speculoos","categorie":"NOURRITURE","batiment":"Restaurant","uniteTravail":1,"produitPar":20,"charge":1,"niveau":1,"capacite":0},{"nom":"Gadget","categorie":"OUTILS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Action","categorie":"BONS D\u0027�TAT / LOTERIE","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1}],"nom":"Truelle","categorie":"OUTILS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"nom":"Artefact Organisation +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Confort","categorie":"SERVICES","batiment":"Restaurant","uniteTravail":1,"produitPar":4,"charge":1,"niveau":3,"capacite":0},{"nom":"?illet","categorie":"PLANTES","batiment":"Ferme","uniteTravail":1,"produitPar":2,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Plastique","nombre":1},{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Trousse M�dicale","categorie":"�LECTRONIQUE","batiment":"�lectronique","uniteTravail":1,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1}],"nom":"Clef","categorie":"CLEFS","uniteTravail":1,"produitPar":5,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Textile","nombre":1}],"nom":"Tableau","categorie":"DIVERS","uniteTravail":4,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":4}],"nom":"Poudre de Silence","categorie":"M�DICAMENTS","batiment":"Clinique","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Prospectus �lectoral","categorie":"LIVRES","batiment":"Biblioth�que","uniteTravail":1,"produitPar":10,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Textile","nombre":1}],"nom":"�charpe du Tovaritch Football Club","categorie":"V�TEMENTS ET ACCESSOIRES","batiment":"Tailleur","uniteTravail":1,"produitPar":2,"charge":1,"niveau":2,"capacite":0},{"nom":"M�ta-Concepts de Bolo Polo","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Arcanes Strat�giques de Franck le M�galo","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":4}],"nom":"M�dicament Anti-Putr�faction","categorie":"M�DICAMENTS","batiment":"Clinique","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Artefact S�duction +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Stage - Combat Distance","categorie":"STAGES","batiment":"�cole Sup�rieure","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Pierre","nombre":1}],"nom":"Pierre de Fronde","categorie":"MUNITIONS \u0026 EXPLOSIFS","batiment":"Armurerie","uniteTravail":1,"produitPar":10,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Implant - Combat Contact","categorie":"IMPLANTS","batiment":"Clinique","uniteTravail":1,"produitPar":2,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"L�gume","nombre":4},{"nomObjet":"Fruit","nombre":4},{"nomObjet":"Poisson","nombre":4},{"nomObjet":"Viande","nombre":4}],"nom":"Repas de Luxe","categorie":"REPAS","batiment":"Restaurant","uniteTravail":2,"produitPar":10,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"Cuir","nombre":3},{"nomObjet":"Acier","nombre":5}],"nom":"Lance-Flammes","categorie":"ARMES DE TIR","batiment":"Armurerie","uniteTravail":5,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":4}],"nom":"M�dicament Anti-Allergie Magique","categorie":"M�DICAMENTS","batiment":"Clinique","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Textile","nombre":1}],"nom":"Cape","categorie":"V�TEMENTS ET ACCESSOIRES","batiment":"Tailleur","uniteTravail":2,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Cyber-t�l�commande","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plastique","nombre":1}],"nom":"Nain de Jardin","categorie":"�QUIPEMENT MAISONS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Livre de Cuisine","categorie":"LIVRES","batiment":"Biblioth�que","uniteTravail":1,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Acier","nombre":1}],"nom":"Grille","categorie":"�QUIPEMENT MAISONS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Carte","categorie":"COURRIER","batiment":"Biblioth�que","uniteTravail":1,"produitPar":4,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":4}],"nom":"M�dicament Anti-Bolopolisme","categorie":"M�DICAMENTS","batiment":"Clinique","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Artefact Max Autres Effets +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Stage - Baratin","categorie":"STAGES","batiment":"�cole Sup�rieure","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":4}],"nom":"M�dicament Anti-C�cit�","categorie":"M�DICAMENTS","batiment":"Clinique","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":1},{"nomObjet":"Plante Magique","nombre":1}],"nom":"Potion de Soins","categorie":"POTIONS MAGIQUES","batiment":"Alchimie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"nom":"Artefact Max Soins +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Masque de la Darkette","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":2},{"nomObjet":"Plastique","nombre":3},{"nomObjet":"Carte Electronique","nombre":3}],"nom":"Alarme �lectronique","categorie":"�QUIPEMENT MAISONS","batiment":"�lectronique","uniteTravail":2,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"L�gume","nombre":10}],"nom":"Salade","categorie":"REPAS","batiment":"Restaurant","uniteTravail":1,"produitPar":10,"charge":1,"niveau":1,"capacite":0},{"nom":"Fleur","categorie":"PLANTES","batiment":"Ferme","uniteTravail":1,"produitPar":2,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":2},{"nomObjet":"Anneau en Or","nombre":2}],"nom":"Diad�me Psychique","categorie":"OBJETS MAGIQUES","batiment":"Alchimie","uniteTravail":6,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"nom":"Code honneur elm�rien","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Acier","nombre":1}],"nom":"Syst�me Antivol","categorie":"�QUIPEMENTS DE V�HICULES","batiment":"Quincaillerie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Fruit","nombre":1}],"nom":"Gn�le","categorie":"BOISSONS","batiment":"Restaurant","uniteTravail":1,"produitPar":3,"charge":1,"niveau":3,"capacite":0},{"nom":"Gravures �rotiques d\u0027H�l�ne Nipournicontre","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"L�gume","nombre":8},{"nomObjet":"Viande","nombre":4}],"nom":"Soupe de Homard et Tortue","categorie":"REPAS","batiment":"Restaurant","uniteTravail":1,"produitPar":10,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Acier","nombre":1}],"nom":"Couteau","categorie":"ARMES DE CONTACT","batiment":"Armurerie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact Commerce +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":2}],"nom":"Outils de Voleur","categorie":"OUTILS","batiment":"Quincaillerie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Action Emperor Ernst Blofeld 2 pour enfants","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Cuir","nombre":2},{"nomObjet":"M�tal","nombre":1}],"nom":"Santiags � Roulettes","categorie":"V�TEMENTS ET ACCESSOIRES","batiment":"Tailleur","uniteTravail":3,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Laine","nombre":1},{"nomObjet":"Textile","nombre":1}],"nom":"Polochon","categorie":"ARMES DE CONTACT","batiment":"Tailleur","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Planche","nombre":8},{"nomObjet":"Textile","nombre":4}],"nom":"Voilier","categorie":"BATEAUX","batiment":"Port","uniteTravail":4,"produitPar":1,"charge":5,"niveau":3,"capacite":0},{"nom":"Briquet vert","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plastique","nombre":1}],"nom":"Objet Souvenir","categorie":"DIVERS","batiment":"Statue - Kraland","uniteTravail":1,"produitPar":3,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"R�glementation","categorie":"LIVRES","uniteTravail":2,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"?il Arrach�","categorie":"DIVERS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":2},{"nomObjet":"Plastique","nombre":1}],"nom":"Catalyseur","categorie":"�QUIPEMENTS DE V�HICULES","batiment":"Garage","uniteTravail":1,"produitPar":2,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":6},{"nomObjet":"Moteur","nombre":4}],"nom":"H�licopt�re","categorie":"AVIONS","batiment":"A�roport","uniteTravail":8,"produitPar":1,"charge":5,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Acier","nombre":1}],"nom":"Machette","categorie":"ARMES DE CONTACT","batiment":"Armurerie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1},{"nomObjet":"Textile","nombre":2}],"nom":"Sac � Dos","categorie":"V�TEMENTS ET ACCESSOIRES","batiment":"Tailleur","uniteTravail":1,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Planche","nombre":1},{"nomObjet":"Moteur","nombre":1}],"nom":"Vedette","categorie":"BATEAUX","batiment":"Port","uniteTravail":1,"produitPar":1,"charge":0,"niveau":2,"capacite":0},{"nom":"Infirmerie","categorie":"�QUIPEMENT MAISONS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Bon d\u0027Etat - Khanat Elm�rien","categorie":"BONS D\u0027�TAT / LOTERIE","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plastique","nombre":1}],"nom":"Objet","categorie":"DIVERS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":3,"charge":1,"niveau":1,"capacite":0},{"nom":"Pierre","categorie":"MATI�RES PREMI�RES","batiment":"Mine de Pierre","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Briquet rouge","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":4}],"nom":"M�dicament Anti-Iglootisme","categorie":"M�DICAMENTS","batiment":"Clinique","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Champignon","categorie":"NOURRITURE","batiment":"Ferme","uniteTravail":1,"produitPar":10,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Implant - Foi","categorie":"IMPLANTS","batiment":"Clinique","uniteTravail":1,"produitPar":2,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1}],"nom":"Petite Voiture","categorie":"DIVERS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":3,"charge":1,"niveau":1,"capacite":0},{"nom":"Sbleune vert","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Fruit","nombre":1}],"nom":"Rhum","categorie":"BOISSONS","batiment":"Restaurant","uniteTravail":1,"produitPar":3,"charge":1,"niveau":3,"capacite":0},{"nom":"Insigne Militaire Elm�rien","categorie":"DIVERS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":2},{"nomObjet":"Pneu","nombre":2},{"nomObjet":"Moteur","nombre":2}],"nom":"Moto de Course","categorie":"V�HICULES","batiment":"Garage","uniteTravail":4,"produitPar":1,"charge":0,"niveau":3,"capacite":0},{"nom":"M�tal","categorie":"MATI�RES PREMI�RES","batiment":"Mine de Fer","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Fruit","nombre":10}],"nom":"Tarte � la Cr�me","categorie":"NOURRITURE","batiment":"Restaurant","uniteTravail":1,"produitPar":10,"charge":1,"niveau":1,"capacite":0},{"nom":"Stage - Organisation","categorie":"STAGES","batiment":"�cole Sup�rieure","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Verre","nombre":1},{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Agenda �lectronique","categorie":"�LECTRONIQUE","batiment":"�lectronique","uniteTravail":1,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Fleur","nombre":4}],"nom":"Parfum","categorie":"V�TEMENTS ET ACCESSOIRES","batiment":"Bijouterie","uniteTravail":1,"produitPar":2,"charge":1,"niveau":2,"capacite":0},{"nom":"Artefact Vol +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Bon d\u0027Etat - Empire Brun","categorie":"BONS D\u0027�TAT / LOTERIE","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Saint Kraal","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1},{"nomObjet":"Corde","nombre":1}],"nom":"�quipement de Survie","categorie":"OUTILS","batiment":"Quincaillerie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"nom":"Insigne Militaire du Val�gro","categorie":"DIVERS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Cuir","nombre":1},{"nomObjet":"Acier","nombre":1}],"nom":"Plaque de Protection","categorie":"ARMURES","batiment":"Armurerie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Action Emperor Ernst Blofeld 2 pour officiers","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plastique","nombre":1},{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Mouchard","categorie":"�LECTRONIQUE","batiment":"�lectronique","uniteTravail":1,"produitPar":1,"charge":0,"niveau":3,"capacite":0},{"nom":"Artefact Max Pouvoirs +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Caoutchouc","nombre":2}],"nom":"Pneu","categorie":"PRODUITS INTERM�DIAIRES","batiment":"Garage","uniteTravail":1,"produitPar":2,"charge":1,"niveau":2,"capacite":0},{"nom":"Bille de Verre","categorie":"DIVERS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Insigne Militaire Kralandais","categorie":"DIVERS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Casque Ranger Jaune","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plastique","nombre":1},{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Radio","categorie":"�LECTRONIQUE","batiment":"�lectronique","uniteTravail":1,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Plan","categorie":"LIVRES","uniteTravail":2,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact Combat Distance +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plante Magique","nombre":2}],"nom":"Potion de Lenteur","categorie":"POTIONS MAGIQUES","batiment":"Alchimie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":2}],"nom":"Baume de Soins","categorie":"M�DICAMENTS","batiment":"Clinique","uniteTravail":1,"produitPar":4,"charge":1,"niveau":1,"capacite":0},{"nom":"D�chet","categorie":"DIVERS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Acier","nombre":6}],"nom":"Cuirasse","categorie":"ARMURES","batiment":"Armurerie","uniteTravail":6,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1},{"nomObjet":"Textile","nombre":2}],"nom":"Si�ge Suppl�mentaire","categorie":"�QUIPEMENTS DE V�HICULES","batiment":"Tailleur","uniteTravail":1,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Bois","nombre":5},{"nomObjet":"Acier","nombre":4}],"nom":"Fusil de Chasse","categorie":"ARMES DE TIR","batiment":"Armurerie","uniteTravail":6,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"nom":"Lunettes Ma vie en Rose","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Champignon","nombre":10}],"nom":"Omelette aux Champignons","categorie":"REPAS","batiment":"Restaurant","uniteTravail":1,"produitPar":10,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1}],"nom":"Pentacle de Naar","categorie":"BIJOUX","batiment":"Bijouterie","uniteTravail":1,"produitPar":2,"charge":1,"niveau":1,"capacite":0},{"nom":"Stage - Pouvoir","categorie":"STAGES","batiment":"�cole Sup�rieure","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact Sans Effet","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Laine","nombre":1}],"nom":"Corde","categorie":"OUTILS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"nom":"Rounne d\u0027Acc","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":6},{"nomObjet":"Pneu","nombre":4},{"nomObjet":"Moteur","nombre":1}],"nom":"Camionnette","categorie":"V�HICULES","batiment":"Garage","uniteTravail":6,"produitPar":1,"charge":10,"niveau":3,"capacite":0},{"nom":"Bish�nen n�1","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":1}],"nom":"Vitamine Jukramine","categorie":"M�DICAMENTS","batiment":"Clinique","uniteTravail":1,"produitPar":5,"charge":1,"niveau":1,"capacite":0},{"nom":"Bish�nen n�2","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Poudre Noire","nombre":1},{"nomObjet":"Carte Electronique","nombre":1}],"nom":"D�tonateur","categorie":"�LECTRONIQUE","batiment":"�lectronique","uniteTravail":1,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Lampe � Mysti","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"L�gume","nombre":8},{"nomObjet":"Poisson","nombre":4}],"nom":"Repas avec Poisson","categorie":"REPAS","batiment":"Restaurant","uniteTravail":1,"produitPar":10,"charge":1,"niveau":2,"capacite":0},{"nom":"Fiole de Vomi Sbleune","categorie":"M�DICAMENTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Photo �rotique","categorie":"DIVERS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Bish�nen n�3","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":2},{"nomObjet":"Pneu","nombre":2},{"nomObjet":"Moteur","nombre":1}],"nom":"Moto","categorie":"V�HICULES","batiment":"Garage","uniteTravail":3,"produitPar":1,"charge":0,"niveau":2,"capacite":0},{"nom":"Bish�nen n�4","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Bish�nen n�5","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Bish�nen n�6","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Bish�nen n�7","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Bish�nen n�8","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Stage - M�decine","categorie":"STAGES","batiment":"�cole Sup�rieure","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Briquet jaune","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact Perception +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"C�r�ale","nombre":1}],"nom":"Vodka","categorie":"BOISSONS","batiment":"Restaurant","uniteTravail":1,"produitPar":3,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Plante Magique","nombre":2}],"nom":"Potion Inconnue","categorie":"POTIONS MAGIQUES","batiment":"","uniteTravail":2,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Bat Boomerang","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Soutien Psychologique","categorie":"SERVICES","batiment":"Clinique","uniteTravail":1,"produitPar":2,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plastique","nombre":1}],"nom":"Petit Poney","categorie":"DIVERS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":3,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Implant - Vol","categorie":"IMPLANTS","batiment":"Clinique","uniteTravail":1,"produitPar":2,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"Or","nombre":5},{"nomObjet":"Pierre","nombre":1},{"nomObjet":"Anneau en Or","nombre":1}],"nom":"Bague","categorie":"BIJOUX","batiment":"Bijouterie","uniteTravail":3,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Implant - Baratin","categorie":"IMPLANTS","batiment":"Clinique","uniteTravail":1,"produitPar":2,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":2},{"nomObjet":"Bague","nombre":1}],"nom":"Anneau de Pouvoir","categorie":"OBJETS MAGIQUES","batiment":"Alchimie","uniteTravail":6,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Avion en Papier","categorie":"LIVRES","uniteTravail":1,"produitPar":4,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Plastique","nombre":1}],"nom":"Statuette de Shneider Phineras","categorie":"DIVERS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":3,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Laine","nombre":1},{"nomObjet":"Textile","nombre":1}],"nom":"Oreiller","categorie":"V�TEMENTS ET ACCESSOIRES","batiment":"Tailleur","uniteTravail":2,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Plante Magique","nombre":4}],"nom":"Potion de Rapidit�","categorie":"POTIONS MAGIQUES","batiment":"Alchimie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Poungi Articul�","categorie":"CADEAUX DE NO�L","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1}],"nom":"Trappe","categorie":"OUTILS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Plante M�dicinale","nombre":4}],"nom":"M�dicament Anti-Anorexie","categorie":"M�DICAMENTS","batiment":"Clinique","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Essence","nombre":100}],"nom":"Voyage en Avion","categorie":"SERVICES","batiment":"A�roport","uniteTravail":1,"produitPar":2,"charge":1,"niveau":2,"capacite":0},{"nom":"Turban d\u0027Iznogoud","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Insigne Militaire Brun","categorie":"DIVERS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Acier","nombre":6}],"nom":"�p�e Longue","categorie":"ARMES DE CONTACT","batiment":"Armurerie","uniteTravail":6,"produitPar":1,"charge":2,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1}],"nom":"Lime","categorie":"OUTILS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"nom":"Calice Nabla","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"Artefact Max Moral +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"nom":"P�trole","categorie":"MATI�RES PREMI�RES","batiment":"Puits de P�trole","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1},{"nomObjet":"Textile","nombre":2}],"nom":"Tente","categorie":"V�TEMENTS ET ACCESSOIRES","batiment":"Tailleur","uniteTravail":1,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Insigne Militaire Ruthv�ne","categorie":"DIVERS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1},{"nomObjet":"Verre","nombre":1}],"nom":"Lanterne","categorie":"OUTILS","batiment":"Quincaillerie","uniteTravail":1,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"nom":"Fruit","categorie":"NOURRITURE","batiment":"Ferme","uniteTravail":1,"produitPar":10,"charge":1,"niveau":2,"capacite":0},{"nom":"Statistiques du Pr. Jhiday","categorie":"RELIQUES","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Papier","nombre":1}],"nom":"Code Juridique","categorie":"LIVRES","batiment":"Biblioth�que","uniteTravail":1,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"composants":[{"nomObjet":"Plante Magique","nombre":4}],"nom":"Potion Amn�sique","categorie":"POTIONS MAGIQUES","batiment":"Alchimie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Artefact �loquence +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Verre","nombre":1},{"nomObjet":"Carte Electronique","nombre":1}],"nom":"D�flecteur Anti-Termondique","categorie":"�LECTRONIQUE","batiment":"�lectronique","uniteTravail":2,"produitPar":1,"charge":1,"niveau":3,"capacite":0},{"nom":"Stage - Survie","categorie":"STAGES","batiment":"�cole Sup�rieure","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"P�trole","nombre":2}],"nom":"Plastique","categorie":"PRODUITS INTERM�DIAIRES","batiment":"Raffinerie","uniteTravail":1,"produitPar":2,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":2},{"nomObjet":"Poudre Noire","nombre":2},{"nomObjet":"Moteur","nombre":1}],"nom":"Missile","categorie":"ARMEMENTS DIVERS","batiment":"Base Militaire","uniteTravail":4,"produitPar":1,"charge":25,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":2},{"nomObjet":"Collier en Or","nombre":1}],"nom":"Collier de Charme","categorie":"OBJETS MAGIQUES","batiment":"Alchimie","uniteTravail":6,"produitPar":1,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"M�tal","nombre":1}],"nom":"Enclume","categorie":"DIVERS","batiment":"Forge","uniteTravail":1,"produitPar":2,"charge":1,"niveau":2,"capacite":0},{"nom":"Artefact Volont� +1","categorie":"ARTEFACTS","uniteTravail":1,"produitPar":1,"charge":1,"niveau":1,"capacite":0},{"composants":[{"nomObjet":"Carte Electronique","nombre":1}],"nom":"Implant - Combat Distance","categorie":"IMPLANTS","batiment":"Clinique","uniteTravail":1,"produitPar":2,"charge":1,"niveau":4,"capacite":0},{"composants":[{"nomObjet":"Bois","nombre":1}],"nom":"Papier","categorie":"PRODUITS INTERM�DIAIRES","batiment":"Scierie","uniteTravail":2,"produitPar":1,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Fruit","nombre":1}],"nom":"Vin","categorie":"BOISSONS","batiment":"Restaurant","uniteTravail":1,"produitPar":5,"charge":1,"niveau":2,"capacite":0},{"composants":[{"nomObjet":"Cuir","nombre":3},{"nomObjet":"Acier","nombre":4}],"nom":"Gilet Pare-Balles","categorie":"ARMURES","batiment":"Armurerie","uniteTravail":4,"produitPar":1,"charge":2,"niveau":4,"capacite":0},{"nom":"Bish�nen","categorie":"SERVICES","batiment":"Restaurant","uniteTravail":2,"produitPar":2,"charge":1,"niveau":4,"capacite":0}]';
var listObjets = JSON.parse(data);
var noImpot = ['BONS D\u0027�TAT / LOTERIE'];

var listMarchandage = [{value:'Achat', label:'Achat'}, {value:'Vente', label:'Vente'}, {value:'AchatVente', label:'Achat & Vente'}];

// Code pour chrome (Eleonore -30207-)
var unsafeWindow;
if(window.navigator.vendor.match(/Google/)) {
	var div = document.createElement("div");
	div.setAttribute("onclick", "return window;");
	unsafeWindow = div.onclick();
} else {
	unsafeWindow = unsafeWindow;
}



//Stock les objets affich�
var registre = [];
/* Objets enregistr�s :
  	{
		indice : ii, // Indice de l'obet
		objet : objet, // Objet (voir data)
		idInpAch : idInpAch, // id de l'input achat
		idInpVt : idInpVt, // id de l'input vente
		idInpCP : idInpCP, // id de l'input cout prod
		idInpGV : idInpGV, // id de l'input gain vente
		idInpRV : idInpRV, // id de l'input gain revente
		idInpImp : idInpImp, // id de l'input de l'impot
		facteurs : facteurs, // list des id des inputs des composant pour le calcul des prix de l'objet
		listeners : listeners, // list des indices des objets qui doivent �tre recalcul� apr�s modif de l'objet
		hasComposant: hasComposant, // objet qui a des composant
		isService : !isAchVent // objet est un service
	};
 */

var tabIdImpot = [];
/* Objets enregistr�s :
	{
		nom : nomImpot, // Nom de l'impot
		idInp : idInp // id de l'input associ�
	};
*/

// 
var idInputSalaire = 'id_inp_salaire';
var idInputMarchandage = 'id_inp_marchandage';
// Bases des id utilis�es pour les nouveaux input
var idInputImpo = 'id_in_imp_';
var idInputAchat = 'id_in_ach_';
var idInputVente = 'id_in_vt_';
var idInputCoutProd = 'id_in_cp_';
var idInputGainVente = 'id_in_gv_';
var idInputGainRevente = 'id_in_rv_';
var idCheckFraude = 'id_inp_fraude';

var thCommerce;
var parentCommerce;
var buttonPosition;
var buttonActive;




// Lance le d�but du script.
init();

/**
 * ALGO:
 * 
 * Quand on arrive sur une page de KI on regarde si on trouve une node TH qui contient le mot cl� commerce.
 * Si oui on ajoute un bouton dans le plus haut TR trouv� dans le tableau.
 * Le bouton d�clenchera le traitemet qui va lire chaque ligne du tableau pour construire de nouvelle colonne.
 * Une fois la construction des colonnes suppl�mentaires on fait disparaitre le bouton.
 * 
 * 
 * Ligne de salaire on met un input avec le salaire initialis� 
 * Ligne de cat�gorie d'objet on met l'input d'impot initialis� (si on le trouve, si on est dans la partie jouer)
 * Ligne d'objet on sauvegarde l'objet on ajoute les cellules, et on calcul en fonction des objets d�j� pr�sent.
 * 
 * 
 * Chaque input on met des fonctions onChange, les modifications sur les input achat/vente on regarde dans le registre
 * les objets listeners de l'objet de la ligne pour leur demander de se mettre � jour.
 *  
 * Pour les impots ou le salaire, tous le monde se met � jour (plus simple).
 *  
 */


// Initialisation du script
function init() {
	// On cherche le noeud du tableau � partir duquel on va faire l'extension de
	// tableau
	var nodesTh = document.getElementsByTagName('th');
	for (var i = 0; i < nodesTh.length; i++) {
		var node = nodesTh[i];

		if (node.firstChild != null) {
			// On prend le noeud dont la node enfant contient le mot cl�
			// "COMMERCE"
			if (node.firstChild.nodeValue == "COMMERCE") {
				thCommerce = node;
				parentCommerce = thCommerce.parentNode;

				/*
					// On v�rifie qu'il y a une caisse apr�s le TR commerce
					var caisseNode = parentCommerce.nextSibling;
					while(caisseNode != null && caisseNode.nodeName != 'IMG') {
						caisseNode = caisseNode.firstChild;
					}
					
					if (caisseNode == null || caisseNode.nodeName != 'IMG' || caisseNode.alt != 'Caisse'){
						thCommerce = null;
					}
				*/
			}
		}
	}
	if (thCommerce != null) {
		// trouver le tr avec le nom du batiment.  Ajoute un bouton dans ce TR pour le d�clenchement du script.
		buttonPosition = parentCommerce.parentNode.firstChild.firstChild; // c'est un TR donc on Descend dans son fils pour ajouter un bouton dans un td.
		buttonActive = addNode(buttonPosition, "input");
		buttonActive.type = 'button';
		buttonActive.value = 'ComMonKI';
		buttonActive.setAttribute('onclick', 'commonki_construction()');
	}
	
}



unsafeWindow.commonki_construction = function () {
//function commonki_construction() {
	// On aggrandi le tableau.
	var search = true;
	var cur = parentCommerce;
	while (search) {
		cur = cur.parentNode;
		if (cur == null || cur.nodeName == 'TABLE') {
			search = false;
		}
	}
	if (cur != null) {
		cur.style='';//width:480px;';
	}
	
	// Ajout d'une ligne de tableau pour le marchandage
	if (marchandageActive) {
		// cr�er un nouveau tr
		var nodeMarchan = document.createElement('tr');
		// on le met juste apr�s le td caisse
		parentCommerce.parentNode.insertBefore(nodeMarchan, parentCommerce.nextSibling.nextSibling);
		// cr�er le tdqui va contenir le tout.
		var tdMarch = addNode(nodeMarchan, 'td');
		tdMarch.className = 'tdb';
		tdMarch.setAttribute('colspan','3');
		traitementMarchandage(tdMarch);
	}
	
	// Parcours des �l�ments du tableau du commerce
	var cursor = parentCommerce.nextSibling; // On est sur les TR
	while (cursor != null) {
		
		var nbChild = cursor.childNodes.length;
		if (nbChild == 0) {
			// au cas ou on tombe sur une node qui n'a pas d'enfant.
			cursor = cursor.nextSibling;
			continue;
		}
		
		var nodeName = cursor.childNodes[0].nodeName;
		var isTd = nodeName == 'TD';
		var isTh = nodeName == 'TH';
		
		if (nbChild == 2 && isTd) {
			// caisse deux child premier fils td
			traitementLigneCaisse(cursor);
		} else if (nbChild == 2 && isTh) {
			// cat�gorie 2 child premier = th
			traitementLigneCategorie(cursor);
		} else if (nbChild == 3) {
			// objet 3 child
			traitementLigneObjet(cursor);
		}
		// On passe au suivant
		cursor = cursor.nextSibling;
	}

	// On retire le bouton qui n'est plus utile.
	buttonPosition.removeChild(buttonActive);
} 



function traitementLigneCaisse(trCaisse) {
	// Si salaire on r�cup�re le salaire et on met l'input.
	var td = trCaisse.childNodes[1];
	var fils = td.childNodes;
	
	var ii = fils.length - 1;
	if (ii < 0) {
		return;
	}
	
	var nodeSalaire = null;
	var chaineSalaire = '';
	var baseSalaire = 10;
	
	if (fils[ii].nodeName == 'P') {
		// on retire l'impot sur le salaire.
		td.removeChild(fils[ii]);
		// on red�cale d'un cran c'est qu'on est dans les cas ou l'info sur l'impot est pr�sente
		ii--;
	} 
	chaineSalaire = fils[ii].nodeValue;
	nodeSalaire = fils[ii];

	// On va r�cup�rer le salaire. 
	// : 3351 �E - Salaire : 50 �E/UT
	var demDeb = {ch :':', pos : 0};
	var demFin = {ch :'/UT', pos : 0};
	demDeb.pos = chaineSalaire.lastIndexOf(demDeb.ch) + demDeb.ch.length;
	demFin.pos = chaineSalaire.indexOf(demFin.ch) - 2;
	
	baseSalaire = parseInt(chaineSalaire.substring(demDeb.pos, demFin.pos).trim());

	// remplace le texte du salaire par l'input
	nodeSalaire.nodeValue = chaineSalaire.substring(0, demDeb.pos); // debut
	var nn = addInputNode(td, idInputSalaire, baseSalaire);
	nn.setAttribute('onchange', 'changeGlobal()');
	addTextNode(td, ' ' + chaineSalaire.substring(demFin.pos));
	nn = addNode(td, 'P');
	nn = addCheckboxNode(nn, idCheckFraude, 'val', 'Fraude fiscale');
	nn.setAttribute('onchange', 'changeFraude(this.checked)');
	nn.checked = fraude;
}

function traitementMarchandage(parent) {

	var p = addNode(parent, 'P');
	addTextNode(p,'Marchandage ');
	var nn = addInputNode(p, idInputMarchandage, valeurDefautMarchandage);
	nn.setAttribute('onchange', 'changeGlobal()');
	addTextNode(p,'%');
	
	p = addNode(parent, 'P');	
	// On met les radios button de marchandage
	for (var ii = 0; ii < listMarchandage.length; ii++) {
		var mm = listMarchandage[ii];
		nn = addRadioNode(p, 'cmki_radiom_'+mm.value, mm.value, mm.label);
		nn.name='cmki_radio_marchandage';
		nn.setAttribute('onchange', 'changeTypeMarchandage(this)');
		// si le type de marchandage par defaut correspond, on met le radio checked
		if (mm.value == typeMarchandage) {
			nn.checked = true;
		}
	}

}



function traitementLigneCategorie(trCategorie) {
	// valeur par d�fauts
	var nomImpot = '';
	var valeurImpot = valeurDefautImpot;
	
	// Ajout des ent�tes pour les nouvelles colonnes
	var node = addThNode(trCategorie, 'ths');
	addTextNode(node, "Cout");
	addNode(node, 'br');
	addTextNode(node, "prod");
	node = addThNode(trCategorie, 'ths');
	addTextNode(node, "Gain");
	addNode(node, 'br');
	addTextNode(node, "vente");
	node = addThNode(trCategorie, 'ths');
	addTextNode(node, "Gain");
	addNode(node, 'br');
	addTextNode(node, "revente");
	

	var td = trCategorie.childNodes[0];
	var chaineCat = td.firstChild.nodeValue;
	var pos = chaineCat.indexOf('(');
	if (pos == -1) {
		// Cas pas d'info sur l'impot
		nomImpot = chaineCat.trim();
	} else {
		nomImpot = chaineCat.substring(0, pos-1).trim();
		// traitement base de l'impot
		
		var cValImpot = chaineCat.substring(pos);
		
		var demDeb = {ch :' ', pos : 0};
		var demFin = {ch :'%', pos : 0};
		demDeb.pos = cValImpot.lastIndexOf(demDeb.ch) + demDeb.ch.length;
		demFin.pos = cValImpot.indexOf(demFin.ch);
		valeurImpot = parseInt(cValImpot.substring(demDeb.pos, demFin.pos).trim());
	}
	td.firstChild.nodeValue = nomImpot;

	// On va v�rifier qu'on mettre des impots sur cette cat�gorie
	for (var o = 0 ; o < noImpot.length; o++) {
		if (nomImpot == noImpot[o]) {
			// On arr�te le traitement on doit pas avoir d'impot sur cette cat�gorie.
			return;
		}
	}
	
	// On enregistre l'impot dans le tableaux des impots.
	var cc = tabIdImpot.length;
	var idInp = idInputImpo + cc;
	tabIdImpot[cc] = {
		nom : nomImpot,
		idInp : idInp
	};

	
	var p = addNode(td, 'P');
	addTextNode(p,'Imp�t vente ');
	var nn = addInputNode(p, idInp, valeurImpot);
	nn.setAttribute('onchange', 'changeGlobal()');
	addTextNode(p,'%');
}


function traitementLigneObjet(trObjet) {
	// si objet on l'enregistre et on cr�� les id et les cellules 
	var ii = registre.length;
	var idInpCP = idInputCoutProd + ii;
	var idInpVt = idInputVente + ii;
	var idInpGV = idInputGainVente + ii;
	var idInpAch = null;
	var idInpRV = null;
	var idInpImp = null;
	var facteurs = [];
	var listeners = [];
	
	var nomObj = trObjet.firstChild.firstChild.alt; // on sait qu'il y a une image dont l'alt est le nom de l'objet
	var objet = null;
	// On va chercher l'objet dans notre 'biblioth�que des objets'
	for (var o = 0; o < listObjets.length; o++) {
		if (listObjets[o].nom == nomObj) {
			objet = listObjets[o];
			break;
		}
	}
	if (objet == null) {
		return;
	}

	if (objet.composants != null && objet.composants.length > 0) {
		var cpFound = [];
		var produitIci = true;
	
		// Si notre objet a normalement des composants alors on va parcourirs 
		// ces composant pour les trouvers dans les objets d�j� enregistr�
		// si on les trouves on enregistre l'objet courant en tant que listener
		// et on r�cup�re autant de fois que n�cessaire l'id du coup de prod
		// pour les calculs concernant le cout de l'objet courant
		// MAIS on fait tout �a seulement si le commerce en cours de traitement
		// vend bien tous les composants
		for (var oo = 0; oo < objet.composants.length; oo++) {
			var compo =  objet.composants[oo];
			var objFo = null;
			
			for (var rr = 0; rr < registre.length; rr++) {
				var objRe = registre[rr];
				if (objRe.objet.nom == compo.nomObjet) {
					objFo = objRe;
					break;
				}
			}
			if (objFo == null) {
				produitIci = false;
				break;
			} else {
				// Un objet trouve est associ� � son composant pour la suite
				cpFound[cpFound.length] = {
						compo : compo,
						objRe : objFo
				};
			}
		}
		
		if (produitIci) {
			for (var cp = 0; cp <cpFound.length; cp++) {
				// si l'objet composant n'a pas de composant le prix doit etre  
				// calcul� avec le prix d'achat de l'objet composant
				var idPrixCompo = cpFound[cp].objRe.idInpAch;
				if (cpFound[cp].objRe.hasComposant) {
					idPrixCompo = cpFound[cp].objRe.idInpCP;
				}
				for (var nb = 0; nb < cpFound[cp].compo.nombre; nb++) {
					facteurs[facteurs.length] = idPrixCompo;
				}
				cpFound[cp].objRe.listeners[cpFound[cp].objRe.listeners.length]=ii;
			}
		}
	}
	var hasComposant = facteurs.length > 0;
	
	// R�cup�re le prix vente/achat de l'objet
	var pPrix = trObjet.childNodes[2].firstChild;
	var chainePrix = pPrix.firstChild.nodeValue;
	pPrix.removeChild(pPrix.firstChild);

	// Si mine ou exploitation de bois
	if (chainePrix.indexOf('-') != -1) {
		return;
	}
	
	// on va d�terminer s'il s'agit un objet ou d'un service au sens g�n�ral.
	// D�termin� par la pr�sence d'un prix d'achat.
	var posSep = chainePrix.indexOf('/');
	var isAchVent = posSep != -1;

	
	var prixVente = 0;
	var prixAchat = 0;
	
	// Si c'est un objet achat et vente on va r�cup�rer les deux valeurs
	// sinon seulement la valeur de vente.
	if (isAchVent) {
		prixAchat = parseInt(chainePrix.substring(posSep + 1).trim());
	} else {
		posSep = chainePrix.length;
	}
	prixVente = parseInt(chainePrix.substring(0, posSep).trim());
	
	
	// ajout des inputs pour les prix des objets
	var nn = addInputNode(pPrix, idInpVt, prixVente);
	nn.setAttribute("onchange", "changement(" + ii + ")");
	if (isAchVent) {
		idInpAch = idInputAchat + ii;
		addTextNode(pPrix, '/');
		nn = addInputNode(pPrix, idInpAch, prixAchat);
		nn.setAttribute("onchange", "changement(" + ii + ")");
	}
	
		
	// On ajoute les cellules de tableaux avec les donn�s calcul�e
	var tdCp = addTdNode(trObjet, 'tdb');
	var tdGv = addTdNode(trObjet, 'tdb');
	var tdGr = addTdNode(trObjet, 'tdb');
	// Puis les inputs en fonction du type d'objet
	if (hasComposant || !isAchVent) {
		addInputNode(tdCp, idInpCP, 0, true);
	}
	if (hasComposant || !isAchVent) {
		addInputNode(tdGv, idInpGV, 0, true);
	}
	if (isAchVent) {
		idInpRV = idInputGainRevente + ii;
		addInputNode(tdGr, idInpRV, 0, true);
	}

	
	// la case de l'impot c'est forc�ment le dernier impot enregistr�.
	// on va v�rifier cel� dit que ca correspond et que le tableau des impots
	// n'est pas vide
	if (tabIdImpot.length > 0) {
		var im = tabIdImpot[tabIdImpot.length - 1];
		if (im.nom == objet.categorie) {
			idInpImp = im.idInp;
		}
	}
	
	// sauvegarde de l'objet, son indice, ses inputs
	registre[ii] = {
		indice : ii,
		objet : objet,
		idInpAch : idInpAch,
		idInpVt : idInpVt,
		idInpCP : idInpCP,
		idInpGV : idInpGV,
		idInpRV : idInpRV,
		idInpImp : idInpImp,
		facteurs : facteurs,
		listeners : listeners, 
		hasComposant: hasComposant,
		isService : !isAchVent
	};
	// On recalcul aussitot.
	recalcul(registre[ii]);
}


/** Fonctions d'�coute et d'action */

/**
 * Fonction d�clench�e au changement de valeur de salaire ou d'impots ou de marchandage
 * D�clenche la mise � jour de tous les �l�ments du registre.
 */
unsafeWindow.changeGlobal = function () {
//function changeGlobal() {
	for (var i = 0; i < registre.length; i++) {
		changement(i);
	}
}

/**
 * Fonction d�clench�e au changement de valeur de la checkbox sur la fraude
 * D�clenche la mise � jour de tous les �l�ments du registre.
 */
unsafeWindow.changeFraude = function (checked) {
//function changeFraude() {
	fraude = checked;
	changeGlobal();
}


/**
 * Fonction d�clench�e au clic sur un radio button de marchandage
 * pour changer le type de marchandage et recalculer l'ensemble
 */
unsafeWindow.changeTypeMarchandage = function (radio) {
//function changeTypeMarchandage(radio) {
	typeMarchandage = radio.value;
	changeGlobal();
}


/**
 * Fonction appell�e lors d'un changement sur un input pour que les diff�rentes
 * donn�es �conomiques soient mise � jour.
 * 
 * @param indice
 */
unsafeWindow.changement = function (indice) {
//function changement(indice) {
	// R�cup�ration de l'indice de l'objet modifi�
	var el = registre[indice];
	// recalcul de ses donn�es
	recalcul(el);
	// si des objets sont listeners, on les mets a jours.
	if (el.listeners == null || el.listeners.length == 0) {
		return;
	}
	for (var i = 0; i < el.listeners.length; i++) {
		recalcul(registre[parseInt(el.listeners[i])]);
	}
}


/**
 * Recalcul des donn�es �conomiques d'un objet pass� en param�tre
 * 
 * @param Objet
 *            objet dont on veut recalculer les donn�es
 */
function recalcul (registree) {
	var iObj = 0;
	// Si ya une case impot on la r�cup�re
	if (registree.idInpImp != null) {
		iObj = getEl(registree.idInpImp).value;
	}
	if (fraude) {
		iObj = iObj/2;
	}

	var marchandage = 0;
	if (marchandageActive) {
		marchandage = getEl(idInputMarchandage).value;
	}
	
	var pVente = getEl(registree.idInpVt).value;
	
	// On ajoute le marchandage
	if (isMarchandageVente()) {
		pVente = calculPourcentage(pVente, marchandage, false);
	}
	
	if (registree.idInpAch != null) {
		var pAchat = getEl(registree.idInpAch).value;
		// On ajoute le marchandage
		if (isMarchandageAchat()) {
			pAchat = calculPourcentage(pAchat, marchandage, true);
		}
		var grv = calculGainReVente(pVente, pAchat, iObj);
		getEl(registree.idInpRV).value = cmk_round(grv);
	}
	
	if (registree.facteurs != null && registree.facteurs.length > 0 || registree.isService) {
		var salaire = 0;
		var nn = getEl(idInputSalaire);
		if (nn != null) {
			salaire = nn.value;
		}
		var ut = registree.objet.uniteTravail;
		var nbProd = registree.objet.produitPar;
		var tabPrixComposant = [];

		// on parcours les facteurs a additionner pour calculer le prix
		// facteurs = cout prod ou cout achat des composant
		if (registree.facteurs != null) {
			for (var i = 0; i < registree.facteurs.length; i++) {
				var idFact = registree.facteurs[i];
				var valeur = getEl(idFact).value;
				// Si le facteurs contient la base de l'id achat
				// et qu'on est en mode achat on augmente la valeur du marchandage
				if (isMarchandageAchat() && idFact.indexOf(idInputAchat) > -1) {
					valeur = calculPourcentage(valeur, marchandage, true); 
				}
				tabPrixComposant[i] = valeur;
			}
		}

		var cProd = calculCoutProd(salaire, ut, tabPrixComposant);
		// Le marchandage sur le prix de vente est d�j� calcul� au moment ou on r�cup�re la valeur
		var gv = calculGainVente(pVente, cProd, nbProd, iObj);
		getEl(registree.idInpCP).value = cmk_round(cProd);
		getEl(registree.idInpGV).value = cmk_round(gv);
	}
}

/**
 * Retourne sur le marchandage est en mode achat
 * @returns {Boolean}
 */
function isMarchandageAchat() {
	return (typeMarchandage == 'Achat' || typeMarchandage == 'AchatVente') && marchandageActive; 
}

/**
 * Retourne sur le marchandage est en mode vente
 * @returns {Boolean}
 */
function isMarchandageVente() {
	return (typeMarchandage == 'Vente' || typeMarchandage == 'AchatVente') && marchandageActive; 
}


/**
 * Fonction de calcul.
 */

/**
 * Calcul du gain lors d'une vente d'un produit fabriqu� dans le commerce
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
 * Calcul du gain lors de la vente d'un objet revendu apr�s achat
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
 *            nombre d'unit� de travail
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
 * Fonction d'arrondi
 * @param cc nombre a arrondir
 * @returns {Number} nombre arrondi a 1 chiffre apr�s la virgule
 */
function cmk_round(cc) {
	return Math.round(cc*10)/10;
}


/**
 * Fonctions utilitaires Cr�ation de node, ajout de node. etc.
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
 * @returns noeud cr��
 */
function addNode(NodeParent, typeNode) {
	var node = document.createElement(typeNode);
	NodeParent.appendChild(node);
	return node;
}

/**
 * Ajout d'une node input radio avec label associ�
 * @param NodeParent parend
 * @param id id du radio
 * @param valeur valeur 
 * @param label label, si vide pas de label
 */
function addRadioNode(NodeParent, id, valeur, label) {
	var node = addNode(NodeParent, "input");
	node.id = id;
	node.value = valeur;
	node.type = 'radio';
	if (label != null && label.length > 0) {
		var nodelabel = addNode(NodeParent, 'label');
		nodelabel.setAttribute('for', id);
		addTextNode(nodelabel, label);
	}
	return node;
}

/**
 * Ajout d'une node input checkbox avec label associ�
 * @param NodeParent parend
 * @param id id du radio
 * @param valeur valeur 
 * @param label label, si vide pas de label
 */
function addCheckboxNode(NodeParent, id, valeur, label) {
	var node = addNode(NodeParent, "input");
	node.id = id;
	node.value = valeur;
	node.type = 'checkbox';
	if (label != null && label.length > 0) {
		var nodelabel = addNode(NodeParent, 'label');
		nodelabel.setAttribute('for', id);
		addTextNode(nodelabel, label);
	}
	return node;
}

/**
 * Ajout d'une node input text
 * 
 * @param NodeParent parent
 * @param id du noeud
 * @param valeur valeur
 * @param readO readonly
 */
function addInputNode(NodeParent, id, valeur, readO) {
	var node = addNode(NodeParent, "input");
	node.type = 'text';
	node.id = id;
	node.value = valeur;
	node.style='width: 40px; text-align: right;';
	
	if (readO != null) {
		node.disabled = readO;
	}
	return node;
}

function addThNode(NodeParent, className) {
	var node = addNode(NodeParent, "th");
	node.className = className;
	return node;
}

function addTdNode(NodeParent, className) {
	var node = addNode(NodeParent, "td");
	node.className = className;
	node.style='text-align: center;';
	return node;
}

function addTextNode(NodeParent, text) {
	var node = document.createTextNode(text);
	NodeParent.appendChild(node);
}


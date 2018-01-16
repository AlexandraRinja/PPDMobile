import firebase from "firebase/index"

export class FirebaseWorker {
    static currentID = 0;

    static getLoggedUser() {
        return firebase.auth().currentUser.email;
    }

    static getRecipeList() {
        let recipe_list = [];

        let leadsRef = firebase.database().ref('recipes');
        leadsRef.on('value', function (snapshot) {
            snapshot.forEach(function (childSnapshot) {
                let childData = childSnapshot.val();
                console.log(childData);
                recipe_list.push(childData);
            });
        });
        console.log(recipe_list);
        return recipe_list;
    }

    static addRecipe(name, ingredient) {
        FirebaseWorker.getNumberOfRecipes();
        let id = firebase.database().ref().child('recipes').push().key;
        firebase.database().ref('recipes').child(FirebaseWorker.currentID).update({
            id: FirebaseWorker.currentID,
            name: name,
            ingredients: ingredient
        });
        console.log("QQQQQ");
    }

    static getNumberOfRecipes() {
        let leadsRef = firebase.database().ref('recipes');
        leadsRef.on('value', function (snapshot) {
            FirebaseWorker.currentID = snapshot.numChildren();
        });
    }

    static updateRecipe(recipe){

        firebase.database().ref('recipes').child(recipe.id).update(recipe);
    }

    static deleteReceipt(recipe){
        firebase.database().ref('recipes').child(recipe.id).remove();
    }

}
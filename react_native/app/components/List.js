import React from 'react';
import {AsyncStorage} from "react-native";
import {Alert} from "react-native";

export class List extends React.Component {


    constructor(props) {
        super(props);

        this.data = {listOfRecipes: [], max_id: 0};
        this.updateList().done();
    }

    async updateList()
    {
        try
        {
            let response = await AsyncStorage.getItem("listOfRecipes");

            let parsed = await JSON.parse(response) || {listOfRecipes: [], max_id: 0};

            this.data = parsed;

        }
        catch(error)
        {
            console.log(error);
        }
    }


    async handleAddRecipe(recipe)
    {
        recipe.id=this.data.max_id;
        let listOfRecipes = [...this.data.listOfRecipes, {recipe: recipe}];
        let max_id = this.data.max_id + 1;

        console.log("data: ", this.data.listOfRecipes);
        console.log("local: ", listOfRecipes);

        await AsyncStorage.setItem("listOfRecipes", JSON.stringify({listOfRecipes: listOfRecipes, max_id: max_id}));
        this.updateList().done();
        console.log("Ending");
    }


    async handleChangedObject(receipt)
    {
        let listOfRecipes = this.data.listOfRecipes;
        console.log("PUKA",listOfRecipes);
        for (let i = 0; i < listOfRecipes.length; i++) {
            if (listOfRecipes[i].recipe.id === receipt.id) {
                console.log("PUKA");
                listOfRecipes[i].recipe=receipt
            }
        }
        await AsyncStorage.setItem("listOfRecipes", JSON.stringify({listOfRecipes: listOfRecipes, max_id: this.data.max_id}));
        this.updateList().done();
    }


    async handleClickedDelete(index)
    {
        //console.log("Delete: ", index);

        let listOfRecipes = this.data.listOfRecipes;

        listOfRecipes.splice(index, 1);

        await AsyncStorage.setItem("listOfRecipes", JSON.stringify({listOfRecipes: listOfRecipes, max_id: this.data.max_id}));

        this.updateList().done()
    }
}
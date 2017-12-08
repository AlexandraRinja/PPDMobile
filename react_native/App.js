import React from 'react';

import {StackNavigator,AsyncStorage} from 'react-navigation';
import Main from './app/components/Main';
import Register from "./app/components/Register";
import Receipts from "./app/components/Receipts";
import EditReceipt from "./app/components/EditReceipt";
import {getRecipesList} from './app/repository/RecipesRepo';
import AddRecipes from "./app/components/AddRecipes";
global.receipts = [
    {
        id: 1,
        name: 'receipt1',
        ingredients: 'ingredient1'
    }, {
        id: 2,
        name: 'receipt2',
        ingredients: 'ingredient2'
    }, {
        id: 3,
        name: 'receipt3',
        ingredients: 'ingredient3'
    }];


const ModalStack=StackNavigator({
    Home: {screen: Main},
    Register:{screen:Register},
    Receipts:{screen:Receipts},
    AddRecipes:{screen:AddRecipes},
    EditReceipt: {screen: EditReceipt, path: 'EditReceipt/:receipt'}
});
export default ModalStack;
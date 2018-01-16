import React from 'react';

import {StackNavigator, AsyncStorage} from 'react-navigation';
import Main from './app/components/shared_components/Main';
import Register from "./app/components/authentification_components/Register";
import Receipts from "./app/components/shared_components/Receipts";
import EditReceipt from "./app/components/superuser_components/EditReceipt";
import {getRecipesList} from './app/repository/RecipesRepo';
import AddRecipes from "./app/components/superuser_components/AddRecipes";
import firebase from "firebase/index";
import Login from "./app/components/authentification_components/Login";
import PowerUserView from "./app/components/superuser_components/PowerUserView";
import {SimpleUserView} from "./app/components/simple_user_components/SimpleUserView";

const config = {
    apiKey: "AIzaSyA4Ls2c0fgDazUOVISXldkNx4iDJNerV1I",
    authDomain: "pmobile-77477.firebaseapp.com",
    databaseURL: "https://pmobile-77477.firebaseio.com",
    projectId: "pmobile-77477",
    storageBucket: "pmobile-77477.appspot.com",
    messagingSenderId: "291087553780"
};
firebase.initializeApp(config);

const ModalStack=StackNavigator({
    Home: {screen: Main},
    SimpleUserView: {screen: SimpleUserView},
    PowerUserScreen: {screen: PowerUserView},
    Register:{screen:Register},
    Login:{screen: Login},
    Receipts:{screen:Receipts},
    AddRecipes:{screen:AddRecipes},
    EditReceipt: {screen: EditReceipt, path: 'EditReceipt/:receipt'}
});

export default ModalStack;

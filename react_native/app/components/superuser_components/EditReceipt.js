import React from 'react';
import {Button, Linking, TextInput, View, StyleSheet, Text, Alert} from 'react-native';
import {FirebaseWorker} from "../shared_components/FirebaseWorker";


export default class EditReceipt extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            id: 0,
            name: "",
            ingredients: ""
        };
    }

    _onPress(recipe) {
        FirebaseWorker.updateRecipe(recipe);
        this.props.navigation.navigate("Receipts", {repo: this.repo});
    }

    _onPress2(recipe) {
       FirebaseWorker.deleteReceipt(recipe);
        this.props.navigation.navigate("Receipts", {repo: this.repo});
    }

    render() {
        const {receipt} = this.props.navigation.state.params;
        console.log(receipt);
        this.id = receipt.id;
        this.name = receipt.name;
        this.ingredients = receipt.ingredients;
        return (
            <View style={styles.myView}>
                <Text style={styles.myText}>Edit receipt</Text>
                <View style={styles.inputForm}>

                    <TextInput style={styles.inputText}
                               onChangeText={(text) => {
                                   console.log(text);
                                   this.name = text;
                               }}>
                        {this.name}</TextInput>

                    <TextInput style={styles.inputText1}
                               onChangeText={(text) => this.ingredients = text}
                    >{this.ingredients}</TextInput>

                </View>
                <View style={styles.myButton}>
                    <Button onPress={() => {
                        receipt.name = this.name;
                        receipt.ingredients = this.ingredients;
                        this._onPress(receipt);
                    }} title="Submit" color='#FDEBD0'/>
                </View>
                <View style={styles.myButton}>
                    <Button onPress={() => this._onPress2(receipt)} title="Delete" color='#FDEBD0'/>
                </View>
            </View>
        );
    }
};
const styles = StyleSheet.create({
    myView: {
        height: 600,
        width: 400,
        backgroundColor: '#FDEBD0'
    },
    myText: {
        marginTop: 60,
        fontSize: 60,
        textAlign: 'center',
        color: '#48C9B0'
    },
    inputText: {
        height: 30,
        width: 300,
        backgroundColor: '#48C9B0',
        color: 'white',
    },
    myButton: {
        height: 100,
        width: 100,
        marginTop: 20,
        marginLeft: 100,
        backgroundColor: '#48C9B0',
        borderRadius: 20,
        padding: 10,
        shadowOffset: {
            width: 0,
            height: 3
        },
        shadowRadius: 10,
        shadowOpacity: 0.25
    },
    inputText1: {
        marginTop: 10,
        height: 30,
        width: 300,
        backgroundColor: '#48C9B0',
        color: 'white',
    },
    myList: {
        marginTop: 50
    },
    listItem: {
        marginTop: 10,
        fontSize: 20,
        color: '#48C9B0'
    }
});
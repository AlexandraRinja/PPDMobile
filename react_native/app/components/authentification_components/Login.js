import React from "react";
import {Button, StyleSheet, Text, TextInput, View} from "react-native";
import firebase from "firebase/index";

export default class Login extends React.Component {

    static poweruser = false;

    constructor() {
        super();
        this.email = "rinjaalexandra@gmail.com";
        this.password = "alis12";
    }

    async _onPress() {
        const {navigate} = this.props.navigation;
        await firebase.auth().signInWithEmailAndPassword(this.email, this.password).then(function () {
            console.log("NAVIGATEE");
            Login.handleUserSuccessLogin(navigate);
        }).catch(function (error) {
                alert(error.message);
                console.log(error.message);
            }
        );

    }

    render() {
        return (

            <View style={styles.myView}>
                <Text style={styles.myText}>Login</Text>
                <View style={styles.inputForm}>
                    <TextInput style={styles.inputText}
                               placeholder="E-mail..."
                               placehoderTextColor="white"
                               onChangeText={(text) => this.email = text}>
                    </TextInput>
                    <TextInput style={styles.inputText1}
                               placeholder="Password..."
                               placehoderTextColor="white"
                               onChangeText={(text) => this.password = text}>
                    </TextInput>

                    <View style={styles.myButton}>
                        <Button onPress={() => this._onPress()} title="Submit" color='#FDEBD0'/>
                    </View>

                </View>
            </View>
        )
    }

    static handleUserSuccessLogin(navigate) {
        console.log("USER");
        if (Login.isPoweruser()) {
            navigate("PowerUserScreen");
        }
        else {
            navigate("Receipts");
        }
    }

    static isPoweruser() {
        let leadsRef = firebase.database().ref('powerusers');
        leadsRef.on('value', function (snapshot) {
            snapshot.forEach(function (childSnapshot) {
                let childData = childSnapshot.val();
                console.log(childData.email);
                if (childData.email === firebase.auth().currentUser.email) {
                    Login.poweruser = true;
                }
            });
        });

        return Login.poweruser;
    }
}
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
    buttons: {
        flexDirection: 'row',
        marginTop: 200
    },
    myButton: {
        height: 100,
        width: 100,
        marginLeft: 20,
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
    myButton2: {
        height: 100,
        width: 105,
        marginLeft: 10,
        backgroundColor: '#48C9B0',
        borderRadius: 10,
        padding: 10,
        shadowOffset: {
            width: 0,
            height: 3
        },
        shadowRadius: 10,
        shadowOpacity: 0.25
    },
    myButton3: {
        height: 100,
        width: 105,
        marginLeft: 10,
        backgroundColor: '#48C9B0',
        borderRadius: 10,
        padding: 10,
        shadowOffset: {
            width: 0,
            height: 3
        },
        shadowRadius: 10,
        shadowOpacity: 0.25
    },

    myButton4: {
        height: 100,
        width: 105,
        marginLeft: 10,
        backgroundColor: '#48C9B0',
        borderRadius: 10,
        padding: 10,
        shadowOffset: {
            width: 0,
            height: 3
        },
        shadowRadius: 10,
        shadowOpacity: 0.25
    }
});

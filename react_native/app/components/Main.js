import React from 'react';
import {AppRegistry,Text,View,StyleSheet,Button,Alert} from 'react-native'
import {List} from "./List";

export default class Main extends React.Component{
    constructor(){
        super();
        this._repo=new List();
    }

    _onPress1() {
        this.props.navigation.navigate("Register");
    }
    _onPress2(){
        this.props.navigation.navigate("Receipts",{repo:this._repo});
    }
    _onPress3(){
        this.props.navigation.navigate("AddRecipes",{repo:this._repo});
    }

    render(){
        return( //we cand return just one element
            <View style={styles.myView}>
                <Text style={styles.myText}>LifeSum</Text>

                <View style={styles.buttons}>
                    <View style={styles.myButton}>
                        <Button onPress={()=>this._onPress2()} title="View List" color='#FDEBD0'/>
                    </View>

                    <View style={styles.myButton2}>
                        <Button onPress={()=>this._onPress1()} title="Register" color='#FDEBD0'/>
                    </View>

                    <View style={styles.myButton3}>
                        <Button onPress={()=>this._onPress3()} title="Add" color='#FDEBD0'/>
                    </View>

                </View>

            </View>
        );
    }
};

const styles=StyleSheet.create({
    myView:{
        height:600,
        width:400,
        backgroundColor:'#FDEBD0'
    },
    myText:{
        marginTop:60,
        fontSize:60,
        textAlign:'center',
        color:'#48C9B0'
    },
    buttons:{
        flexDirection:'row',
        marginTop:200
    },
    myButton:{
        height:100,
        width:100,
        marginLeft:20,
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
    myButton2:{
        height:100,
        width:105,
        marginLeft:10,
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
    myButton3:{
        height:100,
        width:105,
        marginLeft:10,
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

import React from 'react';
import {AppRegistry,Text,View,StyleSheet,TextInput,Button,Linking} from 'react-native'

export default class Register extends React.Component{
    constructor(props){
        super(props);
        this.state={
            name:'',
            email:'',
            password:''
        };

    }
    _onPress(event){
        Linking.openURL("mailto:"+this.state.email+"?subject=LifeSum&body=Hello "+this.state.name+" welcome to LifeSum");
        this.props.navigation.goBack();
    }
    render(){
        return( //we cand return just one element
            <View style={styles.myView}>
                <Text style={styles.myText}>Register</Text>
                <View style={styles.inputForm}>
                    <TextInput style={styles.inputText}
                               placeholder="Name..."
                               placeholderTextColor="white"
                               onChangeText={(text) => this.setState({name:text})}
                               value={this.state.name}/>

                    <TextInput style={styles.inputText1}
                               placeholder="Email..."
                               placeholderTextColor="white"
                               onChangeText={(text)=>this.setState({email:text})}
                               value={this.state.email.toString()}/>

                    <TextInput style={styles.inputText2}
                               secureTextEntry={true}
                               placeholder="Password..."
                               placeholderTextColor="white"
                               onChangeText={(text)=>this.setState({password:text})}
                               value={this.state.password.toString()}/>
                </View>
                <View style={styles.myButton}>
                    <Button onPress={()=>this._onPress()} title="Submit" color='#FDEBD0'/>
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
        fontSize:40,
        textAlign:'center',
        color:'#48C9B0'
    },
    myButton:{
        height:100,
        width:100,
        marginTop:20,
        marginLeft:100,
        backgroundColor:'#48C9B0',
        borderRadius:20,
        padding:10,
        shadowOffset: {
            width:0,
            height:3
        },
        shadowRadius:10,
        shadowOpacity:0.25
    },
    inputForm:{
        marginTop:20
    },
    inputText:{
        height:30,
        width:300,
        backgroundColor:'#48C9B0',
        color:'white',
    },
    inputText1:{
        marginTop:10,
        height:30,
        width:300,
        backgroundColor:'#48C9B0',
        color:'white',
    },
    inputText2:{
        marginTop:20,
        height:30,
        width:300,
        backgroundColor:'#48C9B0',
        color:'white',
    }
});

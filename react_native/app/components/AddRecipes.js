import React from 'react';
import {Button, Linking, TextInput, View,StyleSheet,Text,Alert} from 'react-native';

export default class AddRecipes extends React.Component {


    constructor(props) {
    super(props);
    this.repo=props.navigation.state.params.repo;

    this.state = {
        id: 0,
        name: "",
        ingredients: ""
    };

}
_onPress() {
        this.repo.handleAddRecipe(this.state);
        this.props.navigation.navigate("Home");
}
render() {
    return (
        <View style={styles.myView}>
            <Text style={styles.myText}>Add receipt</Text>
            <View style={styles.inputForm}>

                <TextInput style={styles.inputText}
                           onChangeText={(text) => this.setState({name:text})}
                           value={this.state.name}/>

                <TextInput style={styles.inputText1}
                           onChangeText={(text)=>this.setState({ingredients:text})}
                           value={this.state.ingredients}/>

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
        fontSize:60,
        textAlign:'center',
        color:'#48C9B0'
    },
    inputText:{
        height:30,
        width:300,
        backgroundColor:'#48C9B0',
        color:'white',
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
    inputText1:{
        marginTop:10,
        height:30,
        width:300,
        backgroundColor:'#48C9B0',
        color:'white',
    },
    myList:{
        marginTop:50
    },
    listItem:{
        marginTop:10,
        fontSize:20,
        color:'#48C9B0'
    }
});
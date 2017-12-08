import React from 'react';
import {AppRegistry,Text,View,StyleSheet,Button,Alert,ListView,TouchableOpacity} from 'react-native'

export default class Receipts extends React.Component{
    constructor(props){
        super(props);
        this.repo=props.navigation.state.params.repo;
        let dataSource = new ListView.DataSource({rowHasChanged: (r1, r2) => r1.Id !== r2.Id});

        this.state = {
            dataSource: dataSource.cloneWithRows(this.repo.data.listOfRecipes)
        };
        console.log(this.state);
    }
    edit(receipt) {
        this.props.navigation.navigate("EditReceipt", {receipt: receipt, repo:this.repo});
    }
    renderRow(receipt) {
        return (
            <TouchableOpacity onPress={() => this.edit(receipt)}>
                <View>
                    <Text style={styles.listItem}>{receipt.recipe.name}</Text>
                </View>
            </TouchableOpacity>
        );
    }
    render(){
        return( //we cand return just one element
            <View style={styles.myView}>
                <Text style={styles.myText}>List of all receipts</Text>
                <ListView style={styles.myList}
                          dataSource={this.state.dataSource}
                          renderRow={this.renderRow.bind(this)}/>
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
    myList:{
        marginTop:50
    },
    listItem:{
        marginTop:10,
        fontSize:20,
        color:'#48C9B0'
    }
});

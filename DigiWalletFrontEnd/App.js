import { StatusBar } from 'expo-status-bar';
import {Button, StyleSheet, Text, View} from 'react-native';
import { getAllUsers } from "./client";
import { useState, useEffect } from "react";

export default function App() {
    const [users, setUsers] = useState([])

    const fetchUsers = () =>
        getAllUsers()
            .then(res => res.json())
            .then( data => {
                console.log(data);
                setUsers(data)
            })

    useEffect(() => {
        console.log("component is mounted");
        fetchUsers();
    }, []);

    return (
        <View style={styles.container}>
            <Text> {users.length} </Text>
            <Text> {users[0]} </Text>
            <Text> Hi </Text>
        </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});

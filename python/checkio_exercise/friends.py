class Friends:
    def __init__(self, connections):
        self.connections = list(connections)

    def add(self, connection):
        if connection in self.connections:
            return False
        self.connections.append(connection)
        return True

    def remove(self, connection):
        if connection not in self.connections:
            return False
        self.connections.remove(connection)
        return True

    def names(self):
        return set(sum(list(map(list,self.connections)),[]))       
        
    def connected(self, name):
        friends = list(filter(lambda con: name in con,self.connections))
        print(friends)
        friends = list(map(list,friends))
        print(friends)
        return set(list(filter(lambda x: x!=name,friends)))
            


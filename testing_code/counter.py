from flask import Flask
import status

app = Flask(__name__)

COUNTERS = {}

# We will use the app decorator and create a route called slash counters.
# specify the variable in route <name>
# let Flask know that the only methods that is allowed to called
# on this function is "POST".
@app.route('/counters/<name>', methods=['POST'])
def create_counter(name):
    """Create a counter"""
    app.logger.info(f"Request to create counter: {name}")
    global COUNTERS
    if name in COUNTERS:
        return {"Message":f"Counter {name} already exists"}, status.HTTP_409_CONFLICT
    COUNTERS[name] = 0
    return {name: COUNTERS[name]}, status.HTTP_201_CREATED

@app.route('/counters/<string:name>', methods=['PUT'])
def update_counter(name):
    """Update a counter"""
    global COUNTERS
    if name in COUNTERS:
        # Increment the counter by 1
        COUNTERS[name] += 1
        return {name: COUNTERS[name]}, status.HTTP_200_OK
    else:
        return '', status.HTTP_404_NOT_FOUND
    
@app.route('/counters/<string:name>', methods=['GET'])
def read_counter(name):
    if name in COUNTERS:
        # Return the counter
        return {name: COUNTERS[name]}, status.HTTP_200_OK
    else:
        return '', status.HTTP_404_NOT_FOUND
    
@app.route('/counters/<string:name>', methods=['DELETE'])
def delete_counter(name):
    if name in COUNTERS:
        del COUNTERS[name]
        return '', status.HTTP_204_NO_CONTENT
    else:
        return '', status.HTTP_404_NOT_FOUND
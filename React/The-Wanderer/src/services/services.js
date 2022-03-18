import axios from 'axios';

const DESTINOS_API_BASE_URL = 'http://localhost:8080/destinos'

class Service {
     
    deleteById(destinosId) {
        return axios.delete(DESTINOS_API_BASE_URL + '/' + destinosId)
    }
}
export default Service;
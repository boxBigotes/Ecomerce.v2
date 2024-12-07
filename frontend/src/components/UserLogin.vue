<template>
  <div class="login">
    <h2>Login</h2>
    <!-- Campos para el nombre de usuario y la contraseña -->
    <input v-model="username" placeholder="Username" />
    <input v-model="password" type="password" placeholder="Password" />
    <button @click="login">Login</button>
  </div>
</template>

<script>
// Importamos axios para hacer solicitudes HTTP al backend
import axios from 'axios';

export default {
  name: 'UserLogin',
  data() {
    return {
      username: '', // Variable para almacenar el nombre de usuario
      password: ''  // Variable para almacenar la contraseña
    };
  },
  methods: {
    // Método que se ejecuta cuando el usuario hace clic en el botón de login
    async login() {
      try {
        // Enviamos la solicitud POST al backend para autenticar al usuario
        const response = await axios.post('http://localhost:8080/api/auth/login', {
          nombre: this.username,  // Enviamos el nombre de usuario
          password: this.password  // Enviamos la contraseña
        });

        // Si la autenticación es exitosa
        if (response.status === 200) {
          // Emite el evento 'authenticated' con true
          this.$emit('authenticated', true);
        } else {
          // Si las credenciales son incorrectas
          alert('Credenciales incorrectas');
          this.$emit('authenticated', false);
        }
      } catch (error) {
        // Capturamos cualquier error que ocurra durante la solicitud
        console.error('Error de autenticación:', error);
        alert('Hubo un error al intentar autenticar.');
        this.$emit('authenticated', false);
      }
    }
  }
};
</script>

<style scoped>
/* Estilo para la forma de login */
.login {
  display: flex;
  flex-direction: column;
  max-width: 300px;
  margin: auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 8px;
  background-color: #f9f9f9;
}

input {
  margin-bottom: 10px;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  padding: 10px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
}

button:hover {
  background-color: #45a049;
}
</style>

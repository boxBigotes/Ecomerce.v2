<template>
  <div id="app">
    <h1>Bienvenido a Ecomerce</h1>
    <Login v-if="!authenticated" @authenticated="handleAuthenticated"/>
    <BarraCategorias v-if="authenticated" />
  </div>
</template>

<script>
import Login from './components/UserLogin.vue';
import BarraCategorias from './components/BarraCategorias.vue';

export default {
  name: 'App',
  components: {
    Login,
    BarraCategorias
  },
  data() {
    return {
      authenticated: false
    };
  },
  methods: {
    handleAuthenticated(status) {
      this.authenticated = status;
    }
  }
};
</script>

<style>
/* Estilos globales */
#app {
  text-align: center;
}
</style>


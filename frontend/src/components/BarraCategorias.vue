<template>
    <div class="barra-categorias">
      <ul>
        <li v-for="categoria in categorias" :key="categoria.id">
          {{ categoria.nombre }}
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  export default {
    name: 'BarraCategorias',
    data() {
      return {
        categorias: [
          { id: 1, nombre: 'Categoría 1' },
          { id: 2, nombre: 'Categoría 2' },
          { id: 3, nombre: 'Categoría 3' }
        ]
      };
    }
  };
  </script>
  
  <style scoped>
  .barra-categorias {
    padding: 20px;
    background-color: #f8f9fa;
  }
  
  ul {
    list-style: none;
    display: flex;
    justify-content: space-around;
  }
  
  li {
    padding: 10px;
    cursor: pointer;
  }
  
  li:hover {
    background-color: #ddd;
  }
  </style>
  
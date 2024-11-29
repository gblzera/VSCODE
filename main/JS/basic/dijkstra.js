function dijkstra(grafo, origem) {
  const V = grafo.length; // Número de vértices no grafo
  const dist = Array(V).fill(Infinity); // Inicializa as distâncias como infinito
  const visitado = Array(V).fill(false); // Inicializa todos os vértices como não visitados

  dist[origem] = 0;

  for (let count = 0; count < V - 1; count++) {
    // Encontra o vértice com a menor distância que ainda não foi visitado
    let u = menorDistancia(dist, visitado, V);

    visitado[u] = true;

    // Atualiza as distâncias dos vértices adj
    for (let v = 0; v < V; v++) {
      // Verifica se há uma aresta válida e se é possível atualizar a distância
      if (
        !visitado[v] && // Vértice não foi visitado
        grafo[u][v] > 0 && // Aresta válida
        dist[u] !== Infinity && // A distância até 'u' foi calculada
        dist[u] + grafo[u][v] < dist[v]
      ) {
        dist[v] = dist[u] + grafo[u][v];
      }
    }
  }

  // Imprime as distâncias
  console.log(`Distâncias a partir do vértice ${origem}:`);
  for (let i = 0; i < V; i++) {
    console.log(`Vértice ${i} \t Distância: ${dist[i]}`);
  }
}

// Função para encontrar o vértice com a menor distância ainda não visitado
function menorDistancia(dist, visitado, V) {
  let min = Infinity;
  let minIndex = -1;

  for (let v = 0; v < V; v++) {
    if (!visitado[v] && dist[v] <= min) {
      min = dist[v];
      minIndex = v;
    }
  }
  return minIndex;
}

// Exemplo de uso
const grafo = [
  [0, 4, 0, 0, 0, 0],
  [4, 0, 8, 0, 0, 0],
  [0, 8, 0, 7, 0, 4],
  [0, 0, 7, 0, 9, 14],
  [0, 0, 0, 9, 0, 10],
  [0, 0, 4, 14, 10, 0],
];

const origem = 0; // Define o vértice inicial
dijkstra(grafo, origem);

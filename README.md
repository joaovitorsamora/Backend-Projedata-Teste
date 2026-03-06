# Factory Production Optimizer 🏭

Este projeto é uma ferramenta de gerenciamento de insumos e otimização de produção industrial. O objetivo principal é auxiliar uma fábrica a decidir o que produzir para maximizar o lucro total, respeitando as limitações do estoque de matérias-primas.

## 🚀 Tecnologias Utilizadas

### Backend
- **Java 17** com **Spring Boot**
- **Spring Data JPA** para persistência
- **Banco de Dados H2** (em memória para facilidade de teste)
- **Maven** para gerenciamento de dependências

## 🧠 Algoritmo de Otimização
O requisito central do projeto é priorizar produtos que tragam o **MAIOR VALOR TOTAL DE VENDA**. 
A lógica implementada segue os seguintes passos:
1. Ordenação dos produtos pelo preço de venda (decrescente).
2. Verificação de estoque para o produto de maior valor.
3. Produção máxima do item mais caro até o esgotamento dos insumos necessários.
4. Repetição do processo para os itens subsequentes com o saldo restante do estoque.

Isso garante que o conflito de matérias-primas seja resolvido priorizando sempre o retorno financeiro.

## 🛠️ Como Executar o Projeto

### Pré-requisitos
- JDK 17 ou superior

### 1. Rodando o Backend
1. Navegue até a pasta do backend:
   ```bash
   cd backend
   ./mvnw spring-boot:run
   ```

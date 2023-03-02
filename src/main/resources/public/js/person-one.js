const $wrapper = document.querySelector('.wrapper-person1')

const grid = new gridjs.Grid({
  columns: [
    'Id',
    'Name'
  ],
  server: {
    url: `/api/v1/person/list/${personId}`,
    then: data => data.map(person => [person.id, person.name])
  }
})

grid.render($wrapper)
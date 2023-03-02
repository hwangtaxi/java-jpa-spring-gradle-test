const $wrapper = document.querySelector('.wrapper-person')

const grid = new gridjs.Grid({
  columns: [
    'Id',
    'Name',
    {
        name: 'Actions',
        formatter: (_, row) => gridjs.html(`<a href='/person/mod/${row.cells[0].data}'>Mod</a> | <a href='/person/del/${row.cells[0].data}'>Del</a> | <a href='/person/get/${row.cells[0].data}'>Get</a>`)
    }
  ],
  search: true,
  sort: true,
  server: {
    url: '/api/v1/person/list',
    then: data => data.map(person => [person.id, person.name])
  }
})

grid.render($wrapper)
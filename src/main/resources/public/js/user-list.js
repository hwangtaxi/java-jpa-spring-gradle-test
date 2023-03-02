const $wrapper = document.querySelector('.wrapper-user')

const grid = new gridjs.Grid({
  columns: [
    'Id',
    'Name',
    'Email',
    'Password',
    {
        name: 'Actions',
        formatter: (_, row) => gridjs.html(`<a href='/user/mod/${row.cells[0].data}'>Mod</a> | <a href='/user/del/${row.cells[0].data}'>Del</a> | <a href='/user/get/${row.cells[0].data}'>Get</a>`)
    }
  ],
  search: true,
  sort: true,
  server: {
    url: '/api/v1/user/list',
    then: data => data.map(user => [user.id, user.name, user.email, user.password])
  }
})

grid.render($wrapper)
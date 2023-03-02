const $wrapper = document.querySelector('.wrapper-user1')

const grid = new gridjs.Grid({
  columns: [
    'Id',
    'Name',
    'Email',
    'Password'
  ],
  server: {
    url: `/api/v1/user/list/${userId}`,
    then: data => data.map(user => [user.id, user.name, user.email, user.password])
  }
})

grid.render($wrapper)
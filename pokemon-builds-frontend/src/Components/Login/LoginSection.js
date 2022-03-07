import React from 'react'

export default function LoginSection() {
  return (
    <div className='login-container'>
        <div className='login-container__title'>Log in</div>
        <label>Username</label>
        <input type='text' />
        <label>Password</label>
        <input type='password' />
    </div>
  )
}
